package ru.tgbot.chatbot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Date;

public class Main{

    public static void main(String[] args) throws TelegramApiException {

        TelegramBotsApi metabot = new TelegramBotsApi(DefaultBotSession.class);
        {
            try {
                System.out.println("Бот запущен !\n" + "Ожидайте ответа пользователя");

                metabot.registerBot(new SelectionOfBots());
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

    }


}
