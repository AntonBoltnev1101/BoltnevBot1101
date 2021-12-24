package ru.tgbot.chatbot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;




public class DDosBot extends TelegramLongPollingBot {



    @Override
    public String getBotUsername() {
        return "@XXX";
    }

    @Override
    public String getBotToken() {
        return "HIDDEN TOKEN";
    }

    @Override
    public void onUpdateReceived(Update update) {


        if (update.hasMessage()) {

            Message message = update.getMessage();

                while (message.hasText()) {
                    SendMessage ddAttack = new SendMessage();
                    ddAttack.setChatId(message.getChatId().toString());
                    ddAttack.setText("ДУДОСЯТ ДУДОСЯТ ДУДОСЯТ ДУДОСЯТ ДУДОСЯТ ДУДОСЯТ ДУДОСЯТ ДУДОСЯТ ДУДОСЯТ ");

                    try
                    {
                        execute(ddAttack);
                    }

                    catch (TelegramApiException e)
                    {
                        e.printStackTrace();
                    }
            }


        }


    }

    }

