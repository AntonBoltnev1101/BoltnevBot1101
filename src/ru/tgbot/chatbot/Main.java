package ru.tgbot.chatbot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {


    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi metaBot = new TelegramBotsApi(DefaultBotSession.class);
        BufferedReader dd = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Бот запущен !\n");
            Thread.sleep(1000);
            System.out.println("1: Обычный режим\n" + "2: DDos Attack\n");
            System.out.print("Выберите режим: ");
            String ddAt = dd.readLine();
            if (ddAt.equals("1")) {
                System.out.println("Выбран обычный режим");
                metaBot.registerBot(new SelectionOfBots());
            }
            else if (ddAt.equals("2")) {
                System.out.println("Выбран режим DDos Attack");
                metaBot.registerBot(new DDosBot());

                do
                {
                    System.out.println("Попытка остановить DDos");
                    System.out.print("Введите число остановки: ");

                }
                while (!dd.readLine().equals("1"));
                System.out.println("Отключение DDos");
                System.out.println("Бот выключен !");
                System.exit(0);

            }


            } catch (TelegramApiException | IOException | InterruptedException e) {
                e.printStackTrace();
            }



    }


}
