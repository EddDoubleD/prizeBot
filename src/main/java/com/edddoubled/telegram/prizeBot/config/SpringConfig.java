package com.edddoubled.telegram.prizeBot.config;

import com.edddoubled.telegram.prizeBot.service.TelegramBot;
import com.edddoubled.telegram.prizeBot.service.handler.MessageHandler;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;

@Configuration
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class SpringConfig {
    TelegramConfig telegramConfig;

    @Bean
    public SetWebhook setWebhookInstance() {
        return SetWebhook.builder()
                .url(telegramConfig.getWebhookPath())
                .build();
    }

    @Bean
    public TelegramBot telegramBot(
       final SetWebhook setWebhook,
       final MessageHandler messageHandler) {
        return  new TelegramBot(setWebhook, telegramConfig, messageHandler);
    }
}
