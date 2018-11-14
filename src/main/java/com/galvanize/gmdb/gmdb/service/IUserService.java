package com.galvanize.gmdb.gmdb.service;

import com.galvanize.gmdb.gmdb.exception.UserAlreadyExistsException;
import com.galvanize.gmdb.gmdb.model.User;
import com.galvanize.gmdb.gmdb.model.UserDto;

public interface IUserService {
    User registerNewUserAccount(UserDto accountDto) throws UserAlreadyExistsException;
}
