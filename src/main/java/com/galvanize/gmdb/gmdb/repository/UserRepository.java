package com.galvanize.gmdb.gmdb.repository;

import com.galvanize.gmdb.gmdb.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {

    User findByEmail(String email);
}
