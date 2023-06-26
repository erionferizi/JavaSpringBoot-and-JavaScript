package com.cacttus.APIQuote.repository;

import com.cacttus.APIQuote.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);



}
