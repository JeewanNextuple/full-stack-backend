package com.nextuple.learning.backend.business;

import com.nextuple.learning.backend.handlers.NoPasswordException;
import com.nextuple.learning.backend.handlers.NoUserNameFoundException;
import com.nextuple.learning.backend.models.LoginUser;
import com.nextuple.learning.backend.models.Recharge;
import com.nextuple.learning.backend.models.User;
import com.nextuple.learning.backend.repositories.UserRepository;
import com.nextuple.learning.backend.services.RechargeService;
import com.nextuple.learning.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RechargeService rechargeService;

    @Override
    public String addNewUser(User user) throws Exception {
        if (userRepo.existsByEmail(user.getEmail())) {
            throw new Exception("Email already exist");
        }
        if(user.getName().isEmpty() || user.getEmail().isEmpty()  || user.getPhone().equals("") ||user.getPassword().isEmpty()){
            throw new Exception("Missing Credentials");
        }
        userRepo.save(user);
        rechargeService.addWallet(new Recharge(0,user.getEmail(), ""));
        return "User added successfully";
    }

    @Override
    public String loginVerification(LoginUser loginCredentials) throws Exception {
        try {
            User user = userRepo.findById(loginCredentials.getEmail()).get();
            if (loginCredentials.getPassword().equals(user.getPassword()))
                return "Login Credentials Verified";
            else throw new NoPasswordException("Invalid Password");
        }catch(NoSuchElementException err){
            throw new NoUserNameFoundException("Username Invalid");
        }
    }
}
