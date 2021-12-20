package ru.tgbot.chatbot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SelectionOfBots extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "@METAELAY_BOT";
    }

    @Override
    public String getBotToken() {
        return "HIDDEN TOKEN";
    }

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage()) {
            Message message = update.getMessage();
            System.out.println("Пользователь написал: " + message.getText());


            if (message.getText().equals("/start"))
            {
                SendMessage startMessage = new SendMessage();
                startMessage.setChatId(message.getChatId().toString());
                startMessage.setText("Вас приветствует @METAELAY !\n" +
                        "Введите свое сообщение и ожидайте ответа...");

                try {
                    execute(startMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }

            else if (message.getText().equals("/exit"))
            {
                SendMessage endMess = new SendMessage();
                endMess.setChatId(message.getChatId().toString());
                endMess.setText("До встречи !");

                try
                {
                    execute(endMess);
                    System.out.println("Бот выключен");
                    System.exit(0);
                }

                catch (TelegramApiException e)
                {
                    e.printStackTrace();
                }
            }

                    else
                    {
                        SendMessage repeaterBot = new SendMessage();
                        repeaterBot.setChatId(message.getChatId().toString());


                        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


                        try
                        {
                            System.out.print("Ответ пользователю: ");
                            String txt = reader.readLine();
                            repeaterBot.setText("Бот говорит: " + txt);
                        }

                        catch (IOException e)
                        {
                            e.printStackTrace();
                        }

                        try
                        {
                            execute(repeaterBot);
                        }

                        catch (TelegramApiException e)
                        {
                            e.printStackTrace();
                        }
                    }
        }
    }
}


