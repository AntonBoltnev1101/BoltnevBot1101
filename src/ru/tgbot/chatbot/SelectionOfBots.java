package ru.tgbot.chatbot;

import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.*;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;


public class SelectionOfBots extends TelegramLongPollingBot {

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
        ArrayList<InputFile> arrayList = new ArrayList<>();

        arrayList.add(new InputFile("https://upload.wikimedia.org/wikipedia/commons/7/75/Rana_esculenta_on_Nymphaea_edit.JPG"));
        arrayList.add(new InputFile("https://simple-fauna.ru/wp-content/uploads/2018/06/lyagushki.jpg"));
        arrayList.add(new InputFile("https://cdnimg.rg.ru/img/content/189/23/62/photo_2020-05-28_16-51-48_d_850.jpg"));

        Collections.shuffle(arrayList);

        if (update.hasMessage())
        {

            Message message = update.getMessage();

            if (update.getMessage().hasText()) {

                System.out.println(update.getMessage()
                        .getFrom()
                        .getFirstName() + ", написал: "
                        + message.getText());



            if (message.getText().equals("/start")) {
                    SendMessage startMessage = new SendMessage();
                    startMessage.setChatId(message.getChatId().toString());
                    startMessage.setText("Вас приветствует @METAELAY !\n" +
                            update.getMessage().getFrom().getFirstName() + ", введите свое сообщение и ожидайте ответа...");

                    try {
                        execute(startMessage);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else if (message.getText().equals("/exit")) {
                    SendMessage endMess = new SendMessage();
                    endMess.setChatId(message.getChatId().toString());
                    endMess.setText("До встречи, " + update.getMessage().getFrom().getFirstName() + " !");


                    try {
                        execute(endMess);
                        System.out.println("Бот выключен");
                        System.exit(0);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else if (message.getText().equals("/pic")) {


                    SendPhoto sendPhoto = new SendPhoto();
                    sendPhoto.setChatId(message.getChatId().toString());
                    sendPhoto.setPhoto(arrayList.get(0));
                    sendPhoto.setCaption("Лягушка");

                    try {
                        execute(sendPhoto);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else {
                    SendMessage repeaterBot = new SendMessage();
                    SendMessage wait = new SendMessage();

                    wait.setChatId(message.getChatId().toString());
                    wait.setText("Вы написали: " + message.getText() + "\n" + "Ожидайте ответа Бота");

                    repeaterBot.setChatId(message.getChatId().toString());


                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


                    try {
                        execute(wait);
                        System.out.print("Ответ пользователю " + update.getMessage()
                                .getFrom()
                                .getFirstName() + ": ");
                        String txt = reader.readLine();
                        repeaterBot.setText("Бот говорит: " + txt);
                        execute(repeaterBot);
                    } catch (IOException | TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
            }

                     else if (update.getMessage().hasVideo()) {
            Video video = update.getMessage().getVideo();
            String fileId = video.getFileId();
            String fileName = video.getFileName();

            System.out.println(update.getMessage().getFrom().getFirstName()
                    + " прислал вам видео: " + fileName);


//                System.out.println(fileName);
//                System.out.println(fileId);

            try {
                downloadFile(fileName,fileId);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

            System.out.println("Ожидайте ответа от " + update.getMessage().getFrom().getFirstName() + "...");
        }



    }

    public void downloadFile(String fileName, String fileId) throws IOException {
        URL url = new URL("https://api.telegram.org/bot" + getBotToken() + "/getFile?file_id=" + fileId);
//        System.out.println("Запрос на скачивание файла через браузер " + url);

        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
        String getFileRsponse = br.readLine();

        JSONObject jresult = new JSONObject(getFileRsponse);
        JSONObject path = jresult.getJSONObject("result");
        String file_path = path.getString("file_path");
//        System.out.println("Путь файла на сервере Telegram: " + file_path);

//        File localFile = new File("D:/IDEAProjects/TelegramBot/resources/uploadfiles/" + fileName);
        File localFile = new File("D:/IDEAProjects/TelegramBot/resources/uploadfiles/" + fileName);

        InputStream is = new URL("https://api.telegram.org/file/bot" + getBotToken() + "/" + file_path).openStream();

        FileUtils.copyInputStreamToFile(is,localFile);

        br.close();
        is.close();

        System.out.println("Файл загружен");
        System.out.println("Путь файла: " + localFile.getAbsolutePath());

    }
}


