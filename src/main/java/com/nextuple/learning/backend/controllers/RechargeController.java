package com.nextuple.learning.backend.controllers;

import com.nextuple.learning.backend.models.Recharge;
import com.nextuple.learning.backend.services.RechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class RechargeController {

    @Autowired
    private RechargeService rechargeService;


    @GetMapping("/all-wallets")
    public ResponseEntity<?> getAllWallets(){
       return new ResponseEntity<>(rechargeService.getAllWallets(), HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/add-to-wallet")
    public ResponseEntity<?> addToWallet(@RequestBody Recharge recharge){
        return new ResponseEntity<>(rechargeService.addMoneyToWallet(recharge),HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/wallet/{username}")
    public ResponseEntity<?> getWalletDetails(@PathVariable String username){
        return new ResponseEntity<>(rechargeService.getWalletInfo(username),HttpStatus.OK);
    }
}
