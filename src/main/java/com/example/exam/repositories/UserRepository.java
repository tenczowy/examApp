package com.example.exam.repositories;

import com.example.exam.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface UserRepository extends CrudRepository<User, Integer> {

    List<User> findUserByName(String name);
    List<User> deleteUserByName(String name);

    boolean existsUserByName(String name);
}
