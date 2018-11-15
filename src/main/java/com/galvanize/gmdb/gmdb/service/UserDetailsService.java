package com.galvanize.gmdb.gmdb.service;


import com.galvanize.gmdb.gmdb.exception.UserAlreadyExistsException;
import com.galvanize.gmdb.gmdb.model.User;
import com.galvanize.gmdb.gmdb.model.UserDto;
import com.galvanize.gmdb.gmdb.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserDetailsService implements IUserService {

    private static final Logger logger = LoggerFactory.getLogger(UserDetailsService.class.getName());

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Override
    public User registerNewUserAccount(final UserDto accountDto) throws UserAlreadyExistsException {

        if (emailExists(accountDto.getEmail())) {
            logger.error("User already exists...no user(s) added.");
            return null;
        }

        final User user = new User();

        user.setUserName(accountDto.getUserName());
        user.setFirstName(accountDto.getFirstName());
        user.setLastName(accountDto.getLastName());
        user.setPassword(passwordEncoder.encode(accountDto.getPassword()));
        user.setEmail(accountDto.getEmail());
        user.setRole(accountDto.getRole());

        return userRepository.save(user);
    }

    private boolean emailExists(final String email) {
        return userRepository.findByEmail(email) != null;
    }
}
