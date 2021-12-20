package ru.tgbot.chatbot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


public class SelectionOfBots extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "@METAELAY_BOT";
    }

    @Override
    public String getBotToken() {
        return "5003834982:AAHiHQYM1mXC4F4-tmg7hXM1USCq62xi-vs";
    }

    @Override
    public void onUpdateReceived(Update update) {
        ArrayList<InputFile> arrayList = new ArrayList<>();

        arrayList.add(new InputFile("https://upload.wikimedia.org/wikipedia/commons/7/75/Rana_esculenta_on_Nymphaea_edit.JPG"));
        arrayList.add(new InputFile("https://simple-fauna.ru/wp-content/uploads/2018/06/lyagushki.jpg"));
        arrayList.add(new InputFile("https://cdnimg.rg.ru/img/content/189/23/62/photo_2020-05-28_16-51-48_d_850.jpg"));

        Collections.shuffle(arrayList);






        if (update.hasMessage() ) {
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

            else if (message.getText().equals("/pic"))
            {


                SendPhoto sendPhoto = new SendPhoto();
                sendPhoto.setChatId(message.getChatId().toString());
                sendPhoto.setPhoto(arrayList.get(0));
                sendPhoto.setCaption("Лягушка");

                try {
                    execute(sendPhoto);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }

                    else
                    {
                        SendMessage repeaterBot = new SendMessage();
                        SendMessage wait = new SendMessage();

                        wait.setChatId(message.getChatId().toString());
                        wait.setText("Вы написали: " + message.getText() + "\n" + "Ожидайте ответа Бота");

                        repeaterBot.setChatId(message.getChatId().toString());



                        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


                        try
                        {
                            execute(wait);
                            System.out.print("Ответ пользователю: ");
                            String txt = reader.readLine();
                            repeaterBot.setText("Бот говорит: " + txt);
                            execute(repeaterBot);
                        }

                        catch (IOException | TelegramApiException e)
                        {
                            e.printStackTrace();
                        }
                    }
        }
    }
}


