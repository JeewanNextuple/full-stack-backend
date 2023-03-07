package com.nextuple.learning.backend.business;

import com.nextuple.learning.backend.models.Recharge;
import com.nextuple.learning.backend.repositories.RechargeRepository;
import com.nextuple.learning.backend.services.RechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class RechargeServiceImpl implements RechargeService {

    @Autowired
    private RechargeRepository rechargeRepo;

    @Override
    public String addWallet(Recharge recharge) {
       rechargeRepo.save(recharge);
       return "Wallet added";
    }

    @Override
    public String addMoneyToWallet(Recharge recharge) {
        Recharge toBeUpdated = rechargeRepo.findByUsername(recharge.getUsername());//THIS USERNAME WILL BE OF USER THAT HAS LOGGED IN TO THE APP SUCCESSFULLY
        String timeStamp;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        timeStamp = dtf.format(LocalDateTime.now());
        toBeUpdated.setAmount(toBeUpdated.getAmount()+recharge.getAmount());
        int updatedAmount = toBeUpdated.getAmount();

        rechargeRepo.save(new Recharge(updatedAmount, recharge.getUsername(), timeStamp));

        return "Amount Added to wallet";
    }

    @Override
    public String reduceMoneyFromWallet(Recharge recharge) {
        //THIS USERNAME WILL BE OF USER THAT HAS LOGGED IN TO THE APP SUCCESSFULLY
        Recharge toBeUpdated = rechargeRepo.findByUsername(recharge.getUsername());
        String timeStamp;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        timeStamp = dtf.format(LocalDateTime.now());
        toBeUpdated.setAmount(toBeUpdated.getAmount()-recharge.getAmount());
        int updatedAmount = toBeUpdated.getAmount();

        rechargeRepo.save(new Recharge(updatedAmount, recharge.getUsername(), timeStamp));

        return "Amount Deducted from wallet";
    }

    @Override
    public List<Recharge> getAllWallets() {
       return rechargeRepo.findAll();
    }

    @Override
    public Recharge getWalletInfo(String username) {
        return rechargeRepo.findByUsername(username);
    }
}
