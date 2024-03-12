package com.edddoubled.telegram.prizeBot.service;

import com.edddoubled.telegram.prizeBot.config.TelegramConfig;
import com.edddoubled.telegram.prizeBot.consts.BotMessageEnum;
import com.edddoubled.telegram.prizeBot.service.handler.MessageHandler;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.starter.SpringWebhookBot;

@Component
public class TelegramBot extends SpringWebhookBot {

    private final TelegramConfig config;
    private final MessageHandler handler;


    public TelegramBot(
        final SetWebhook setWebhook,
        final TelegramConfig config,
        final MessageHandler handler) {

        super(setWebhook);
        this.config = config;
        this.handler = handler;
    }

    @Override
    public String getBotUsername() {
        return config.getBotName();
    }

    @Override
    public String getBotToken() {
        return config.getBotToken();
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        try {
            return handleUpdate(update);
        } catch (IllegalArgumentException e) {
            return new SendMessage(update.getMessage().getChatId().toString(),
                BotMessageEnum.EXCEPTION_ILLEGAL_MESSAGE.getMessage());
        } catch (Exception e) {
            return new SendMessage(update.getMessage().getChatId().toString(),
                BotMessageEnum.EXCEPTION_WHAT_THE_FUCK.getMessage());
        }
    }

    private BotApiMethod<?> handleUpdate(Update update) {
        return handler.answerMessage(update.getMessage());
    }


    @Override
    public String getBotPath() {
        return config.getWebhookPath();
    }
}
