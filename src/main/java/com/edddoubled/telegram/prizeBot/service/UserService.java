package com.edddoubled.telegram.prizeBot.service;

import com.edddoubled.telegram.prizeBot.model.User;
import com.edddoubled.telegram.prizeBot.repository.UserRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class UserService implements UserManagementService {
    UserRepository userRepository;

    @Override
    public User loadUserById(int id) {
        return userRepository.getReferenceById(id);
    }

    @Override
    public Optional<User> loadUserByTelegram(String telegramId) {
        return userRepository.findByTelegram(telegramId);
    }
}
