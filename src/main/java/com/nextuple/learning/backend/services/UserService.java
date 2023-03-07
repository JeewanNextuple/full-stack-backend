package com.nextuple.learning.backend.services;

import com.nextuple.learning.backend.handlers.NoUserNameFoundException;
import com.nextuple.learning.backend.models.LoginUser;
import com.nextuple.learning.backend.models.User;

public interface UserService {
    String addNewUser(User user) throws Exception;
    String loginVerification(LoginUser loginCredentials) throws Exception;
}
