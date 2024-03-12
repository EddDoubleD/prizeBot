package com.edddoubled.telegram.prizeBot.repository;

import com.edddoubled.telegram.prizeBot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByTelegram(String telegram);
}