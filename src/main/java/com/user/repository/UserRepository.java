package com.user.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.user.model.*;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}