package com.edddoubled.telegram.prizeBot.consts;

import lombok.Getter;

@Getter
public enum BotMessageEnum {
    HELP("Нужна помощь ?"),
    HELLO("Привет я Бот"),
    EXCEPTION_ILLEGAL_MESSAGE("Нет, к такому меня не готовили!"),
    EXCEPTION_WHAT_THE_FUCK("Что-то пошло не так. Обратитесь к программисту");

    private final String message;

    BotMessageEnum(String message) {
        this.message = message;
    }
}
