package com.nextuple.learning.backend.services;

import com.nextuple.learning.backend.models.Recharge;

import java.util.List;

public interface RechargeService {
    String addWallet(Recharge recharge);
    String addMoneyToWallet(Recharge recharge);
    String reduceMoneyFromWallet(Recharge recharge);
    List<Recharge> getAllWallets();
    Recharge getWalletInfo(String username);
}
