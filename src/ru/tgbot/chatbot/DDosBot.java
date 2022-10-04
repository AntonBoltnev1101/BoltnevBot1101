package ru.tgbot.chatbot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;




public class DDosBot extends TelegramLongPollingBot {



    public String getBotUsername() {
        return "@METAELAY_BOT:";
    }

    @Override
    public String getBotToken() {
        return "5003834982:AAHiHQYM1mXC4F4-tmg7hXM1USCq62xi-vs";
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