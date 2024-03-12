package com.edddoubled.telegram.prizeBot.service.handler;

import com.edddoubled.telegram.prizeBot.consts.BotMessageEnum;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Slf4j
public class MessageHandler {

    public BotApiMethod<?> answerMessage(Message message) {
        final String chatId = message.getChatId().toString();
        log.info("Chat {}, message receive ", chatId);

        final String inputText = message.getText();
        if (inputText == null) {
            throw new IllegalArgumentException();
        } else if (inputText.equals("/start")) {
            return getStartMessage(chatId);
        }

        return new SendMessage(chatId, BotMessageEnum.HELLO.getMessage());
    }

    private BotApiMethod<?> getStartMessage(String chatId) {
        SendMessage sendMessage = new SendMessage(chatId, BotMessageEnum.HELP.getMessage());
        sendMessage.enableMarkdown(true);
        return sendMessage;
    }
}
