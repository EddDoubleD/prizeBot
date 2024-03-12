package com.edddoubled.telegram.prizeBot.service;

import com.edddoubled.telegram.prizeBot.model.User;

import java.util.Optional;

public interface UserManagementService {
    User loadUserById(int id);
    Optional<User> loadUserByTelegram(String id);
}
