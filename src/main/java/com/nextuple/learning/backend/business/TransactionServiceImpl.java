package com.nextuple.learning.backend.business;

import com.nextuple.learning.backend.models.Recharge;
import com.nextuple.learning.backend.models.Transaction;
import com.nextuple.learning.backend.repositories.TransactionRepository;
import com.nextuple.learning.backend.services.RechargeService;
import com.nextuple.learning.backend.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

@Service
public class TransactionServiceImpl implements TransactionService {

    private String dateAndTime;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    private static int getCommission(int amount) {
        int commission;
        Random rand = new Random();
        if(amount >100 && amount<500){
            commission = rand.nextInt(3);
        } else if (amount>500 && amount<2000) {
            commission = rand.nextInt(4);
        }else if(amount>2000 && amount<5000){
            commission = rand.nextInt(5);
        }else{
            commission = rand.nextInt(6);
        }
        return commission;
    }

    @Autowired
    private TransactionRepository transactionRepo;

    @Autowired
    private RechargeService rechargeService;

    @Override
    public String saveNewTransaction(Transaction transaction) throws Exception {
        dateAndTime = dtf.format(LocalDateTime.now());

        Recharge walletDetailsForUser = rechargeService.getWalletInfo(transaction.getUsername());
        if (walletDetailsForUser.getAmount() > transaction.getAmount()) {
            int commission = getCommission(transaction.getAmount());
            int cashback = (int) (transaction.getAmount() * commission / 100);

            //NOTE: THE USERNAME PASSED HERE IS FOR DEMO, IN REAL API CALL THIS WILL BE ATTACHED WITH THE REQUEST BODY FOR THE USER THAT IS LOGGED IN.
            Transaction newTransaction = new Transaction(transaction.getTransactionId(), transaction.getName(), transaction.getAccountNumber(), transaction.getEmail(), transaction.getContact(), transaction.getAmount(), cashback, dateAndTime, transaction.getUsername());

            //UPDATING MY WALLET
            rechargeService.reduceMoneyFromWallet(new Recharge(transaction.getAmount(), transaction.getUsername(), dateAndTime));
            rechargeService.addMoneyToWallet(new Recharge(cashback, transaction.getUsername(), dateAndTime));
            //SAVING THE TRANSACTION
            transactionRepo.save(newTransaction);
        } else {
            throw new Exception("Balance too low, kindly recharge the account");
        }
        return "Transaction successful";
    }

    @Override
    public List<Transaction> getTransactionByEmail(String username) {
        return transactionRepo.findTransactionByUsername(username);
    }

    @Override
    public Object getAllCashBacksForUser(String username) {
        List<Transaction> allTransactions = getTransactionByEmail(username);
        Object cashbacks = allTransactions.stream().filter(transaction -> transaction.getCashback()>0);
        return cashbacks;
    }
}
