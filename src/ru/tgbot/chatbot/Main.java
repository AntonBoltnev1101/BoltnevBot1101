package ru.tgbot.chatbot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main{

    public static void main(String[] args) throws TelegramApiException {

        TelegramBotsApi metabot = new TelegramBotsApi(DefaultBotSession.class);
        {
            try {
                metabot.registerBot(new SelectionOfBots());
                System.out.println("Происходит выбор бота");
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }


        System.out.println("Бот запущен !");

    }


}
