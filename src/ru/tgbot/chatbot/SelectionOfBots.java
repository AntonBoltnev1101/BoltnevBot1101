package ru.tgbot.chatbot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class SelectionOfBots extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "@METAELAY_BOT";
    }

    @Override
    public String getBotToken() {
        return "TOKEN";
    }

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage()) {
            Message message = update.getMessage();

            if (message.hasText()) {

//                if (message.hasText() && message.getText().equals("/start")) {
//
//
//                    SendMessage sendMessage2 = new SendMessage();
//                    sendMessage2.setChatId(message.getChatId().toString());
//                    sendMessage2.setText("Добро пожаловать !\n" +
//                            "Выберите тип бота с которым хотите общаться:\n" +
//                            "1 - Бот - повторюшка\n" +
//                            "2 - Бот - автоответчик\n" + "Нажмите 1, если хотите, если хотите выбрать бота - повторюшку\n" +
//                            "Нажмите 2, если хотите выбрать бота - автоответчика: ");
//
//                    try {
//                        execute(sendMessage2);
//                    } catch (TelegramApiException e) {
//                        e.printStackTrace();
//                    }
//                }

                    if (message.hasText()) {
                        SendMessage repeaterBot = new SendMessage();
                        repeaterBot.setChatId(message.getChatId().toString());
                        repeaterBot.setText(message.getText());

                        try {
                            execute(repeaterBot);
                            System.out.println(message.getText());
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }

                    }


            }
        }
    }
}


