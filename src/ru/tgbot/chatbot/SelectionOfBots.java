package ru.tgbot.chatbot;

import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.*;
import org.telegram.telegrambots.meta.api.objects.*;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class SelectionOfBots extends TelegramLongPollingBot {



    @Override
    public String getBotUsername() {
        return "@METAELAY_BOT:";
    }

    @Override
    public String getBotToken() {
        return "5003834982:AAHiHQYM1mXC4F4-tmg7hXM1USCq62xi-vs";
    }

    @Override
    public void onUpdateReceived(Update update) {
        ArrayList<InputFile> arrayList = new ArrayList<>();

        String greg1 = "https://sun9-1.userapi.com/impg/fQ5sCC5v7GGnuDxmz_LX99r7qYZnRNYRUoXFAA/6lPpPVDgs0E.jpg?size=607x1080&quality=95&sign=af8f805168c07a0200f8948d8b61accc&type=album";
        String greg2 = "https://sun9-86.userapi.com/impg/7ntSO1U_sACwkv-ETDzRywYx25mEkj37dlLqMA/jFd0z_3eOho.jpg?size=607x1080&quality=96&sign=9be1027b6b6bd1625e7aea765d451854&type=album";
        String greg3 = "https://sun9-84.userapi.com/impg/ir1tyRDTawxCcVD3ladrre_lSaaYDWzujj3TPA/Q2X1lfZIyKg.jpg?size=607x1080&quality=96&sign=ef96581ea68c8a04bf2d708cef50ecc1&type=album";
        String greg4 = "https://sun9-31.userapi.com/impg/NgHhXDOLDjueLguw2qw5baLOyZzQzDttqi3hlg/R4vJfGCAkDc.jpg?size=607x1080&quality=96&sign=f02f6b4b2e7ed4462d1fa7fe36c2ff1d&type=album";

        arrayList.add(new InputFile("https://upload.wikimedia.org/wikipedia/commons/7/75/Rana_esculenta_on_Nymphaea_edit.JPG"));
        arrayList.add(new InputFile("https://simple-fauna.ru/wp-content/uploads/2018/06/lyagushki.jpg"));
        arrayList.add(new InputFile("https://cdnimg.rg.ru/img/content/189/23/62/photo_2020-05-28_16-51-48_d_850.jpg"));
        arrayList.add(new InputFile("https://i.pinimg.com/originals/e5/c4/47/e5c447bb82d9e15e627d4a550899f1d2.jpg"));
        arrayList.add(new InputFile("https://i.pinimg.com/originals/e5/c4/47/e5c447bb82d9e15e627d4a550899f1d2.jpg"));
        arrayList.add(new InputFile("https://mem-baza.ru/_ph/1/2/367020278.jpg?1600933177"));
        arrayList.add(new InputFile("https://lh3.googleusercontent.com/proxy/dBvqHqUdaBvbtW-xXmasmpvi5KM6QWOjjMOyQWiCtX-u7U5P0hNg9XZfAwvk85jpSmjcWqZPF_jl7rGetEsbtRnAzC7xFqAb"));
        arrayList.add(new InputFile("https://pbs.twimg.com/media/EBf8754WkAASoZ6.jpg"));
        arrayList.add(new InputFile(greg1));
        arrayList.add(new InputFile(greg2));
        arrayList.add(new InputFile(greg3));
        arrayList.add(new InputFile(greg4));

        Collections.shuffle(arrayList);


        ArrayList<String> videoList = new ArrayList<>();
        videoList.add("https://vk.com/video-137866530_456267923");
        videoList.add("https://vk.com/video556488214_456239224");
        videoList.add("https://vk.com/video-152083915_456270344");
        videoList.add("https://vk.com/video146763230_456239474");
        videoList.add("https://vk.com/video-30316056_456350392");
        videoList.add("https://vk.com/video-30316056_456345363");
        videoList.add("https://vk.com/video-30316056_456345615");
        videoList.add("https://vk.com/video-167123504_456252731");
        videoList.add("https://vk.com/video-183694665_456240039");
        videoList.add("https://vk.com/video-167123504_456252660");
        videoList.add("https://vk.com/video-193098763_456251740");
        videoList.add("https://vk.com/video-193098763_456252450");
        videoList.add("https://vk.com/video-193098763_456251907");
        videoList.add("https://vk.com/video-193098763_456248511");
        videoList.add("https://vk.com/video-193098763_456241861");
        videoList.add("https://vk.com/video-196109756_456243868");
        videoList.add("https://vk.com/video-150550417_456247662");
        videoList.add("https://vk.com/video2287579_456239690");

        Collections.shuffle(videoList);

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
                }

            else if (message.getText().equals("/video"))
            {


                SendMessage vidMess = new SendMessage();
                vidMess.setChatId(message.getChatId().toString());
                vidMess.setText(videoList.get(0));



                try {
                    execute(vidMess);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }



            }

            else if (message.getText().equals("/warning"))
            {
                if (update.getMessage().getFrom().getFirstName().equals("Григорий"))
                {
                    SendMessage correctUser = new SendMessage();
                    correctUser.setChatId(message.getChatId().toString());
                    correctUser.setText("Антон заваливает ебало...");

                    try {
                        execute(correctUser);
                        System.out.println("Григорий завалил вам ебало...");
                        System.out.println("Бот выключен !");
                        System.exit(0);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
                else
                {
                    SendMessage wrongUser = new SendMessage();
                    wrongUser.setChatId(message.getChatId().toString());
                    wrongUser.setText("НЕ НАЁБЫВАЙТЕ MIНЭ...\n" + "ВЫ НЕ ГРИГОРИЙ !");

                    try {
                        execute(wrongUser);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
            }

            else if (message.getText().equals("/exit"))
            {
                    SendMessage endMess = new SendMessage();
                    endMess.setChatId(message.getChatId().toString());
                    endMess.setText("До встречи, " + update.getMessage().getFrom().getFirstName() + " !");


                    try
                    {
                        execute(endMess);
                        System.out.println("Бот выключен !");
                        System.exit(0);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }

            else if (message.getText().equals("/riptheskin"))
            {

                if (update.getMessage().getFrom().getFirstName().equals("Anton")) {

                    SendMessage secretButton = new SendMessage();
                    secretButton.setChatId(message.getChatId().toString());
                    secretButton.setText("ЭТО СЕКРЕТНЫЙ НАБОР ВОЗМОЖНОСТЕЙ ДЛЯ ЛЯГУШКИ...");

                    InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

                    InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();
                    inlineKeyboardButton.setText("ПРОЖАТЬ БОТОМ");
                    inlineKeyboardButton.setCallbackData("ВЫ ПРОЖАЛИ БОТОМ ГРИГОРИЯ");

                    InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
                    inlineKeyboardButton1.setText("ХЗ ЗАЧЕМ...");
                    inlineKeyboardButton1.setCallbackData("МДА...");

                    InlineKeyboard(secretButton, inlineKeyboardMarkup, inlineKeyboardButton, inlineKeyboardButton1);


                    try {
                        execute(secretButton);

                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }


                    }



                else if (update.getMessage().getFrom().getFirstName().equals("Noname33"))
                {
                    SendAudio gubaGuba = new SendAudio();
                    gubaGuba.setChatId(message.getChatId().toString());
                    gubaGuba.setAudio(new InputFile(new File("D:/Downloads/fisting-is-300.mp3")));
                    gubaGuba.setCaption(update.getMessage().getFrom().getFirstName()
                            + ", тебя поймал Dungeon Master - Nikita...\n"
                            + "Nikita говорит:");

                    SendAudio gubiGubi = new SendAudio();
                    gubiGubi.setChatId(message.getChatId().toString());
                    gubiGubi.setCaption("Dungeon Master победил и произнёс последний слова...");
                    gubiGubi.setAudio(new InputFile(new File("D:/Downloads/65205306.mp3")));

                    SendAnimation video = new SendAnimation();
                    video.setChatId(message.getChatId().toString());
                    video.setAnimation(new InputFile("https://c.tenor.com/qz7_WifVN0wAAAAC/anal-sex.gif"));
                    video.setCaption("ANAL IS BROKEN");

                    try {
                        execute(gubaGuba);
                        Thread.sleep(2000);
                        execute(gubiGubi);
                        Thread.sleep(2000);
                        execute(video);
                    } catch (TelegramApiException | InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                else
                {
                    SendPhoto wrongNikita = new SendPhoto();
                    wrongNikita.setChatId(message.getChatId().toString());
                    wrongNikita.setPhoto(new InputFile("https://sun9-38.userapi.com/impf/nhZhvxyprmu1oIBkfjCH2VfNyCai-b88wXFi0Q/M_PWtBa6YRQ.jpg?size=1077x853&quality=95&sign=7ddea289dcdfc2b79e0532655250893e&type=album"));
                    wrongNikita.setCaption(update.getMessage().getFrom().getFirstName()
                            + ", вы посягнулись на титул Dungeon Master...");

                    SendAudio sendAudio = new SendAudio();
                    sendAudio.setChatId(message.getChatId().toString());
                    sendAudio.setAudio(new InputFile(new File("D:/Downloads/dungeon-master_lH2ReGX.mp3")));

                    try {
                        execute(wrongNikita);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }

                    try {
                        execute(sendAudio);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
            }


            else if (message.getText().equals("/pic"))
            {

                if (arrayList.get(0).getAttachName().equals(greg1)
                        || arrayList.get(0).getAttachName().equals(greg2)
                        || arrayList.get(0).getAttachName().equals(greg3)
                        || arrayList.get(0).getAttachName().equals(greg4))
                {
                    SendPhoto badPhoto = new SendPhoto();
                    badPhoto.setChatId(message.getChatId().toString());
                    badPhoto.setPhoto(arrayList.get(0));
                    badPhoto.setCaption(update.getMessage().getFrom().getFirstName()
                            + ", тебе попалось бонус фото с уёбком");

                    try {
                        execute(badPhoto);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }

                else
                {
                    SendPhoto sendPhoto = new SendPhoto();
                    sendPhoto.setChatId(message.getChatId().toString());
                    sendPhoto.setPhoto(arrayList.get(0));

                    try {
                        execute(sendPhoto);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
                }

            else
            {
                    SendMessage repeaterBot = new SendMessage();
                    SendMessage wait = new SendMessage();

                    wait.setChatId(message.getChatId().toString());
                    wait.setText("Вы написали: " + message.getText()
                            + "\n" + "Ожидайте ответа Бота");

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

            else if (update.getMessage().hasPhoto())
            {
                SendMessage photo = new SendMessage();
                photo.setChatId(message.getChatId().toString());
                photo.setText("Ошибка...\n" + "Отправьте фото через Файл");

                try {
                    execute(photo);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

            }

            else if (update.getMessage().hasDocument())
            {
                if (message.getDocument().getMimeType().equals("image/png")
                        || message.getDocument().getMimeType().equals("image/jpeg"))
                {

                    System.out.println(update.getMessage().getFrom().getFirstName() + " прислал вам фото");
                }

                else
                {
                    System.out.println(update.getMessage().getFrom().getFirstName() + " прислал вам документ");
                }

                Document document = update.getMessage().getDocument();
                String fileName = document.getFileName();
                String fileId = document.getFileId();

                try {
                    downloadFile(fileName, fileId);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }



                     else if (update.getMessage().hasVideo())
                     {
            Video video = update.getMessage().getVideo();
            String fileId = video.getFileId();
            String fileName = video.getFileName();

            System.out.println(update.getMessage().getFrom().getFirstName()
                    + " прислал вам видео: " + fileName);




            try {
                downloadFile(fileName,fileId);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            System.out.println("Ожидайте ответа от " + update.getMessage().getFrom().getFirstName() + "...");
        }

        else if (update.hasCallbackQuery())
        {
            String call1 = update.getCallbackQuery().getData();
            String chatId = update.getCallbackQuery().getMessage().getChatId().toString();
            if (call1.equals("ВЫ ПРОЖАЛИ БОТОМ ГРИГОРИЯ"))
            {
                SendAudio audio = new SendAudio();
                audio.setChatId(chatId);
                audio.setCaption("БОТОМ ГРИГОРИЯ ПРОЖАТ\n"
                        + "УНИКАЛЬНАЯ АУДИОЗАПИСЬ ПОСЛЕДНИХ СЛОВ ГРИГОРИЯ...");
                audio.setAudio(new InputFile(new File("D:/Downloads/woo_htcxajK.mp3")));


                try {
                    execute(audio);
                    System.out.println(update.getCallbackQuery().getFrom().getFirstName() + " ОТДАЁТ ПРЕДПОЧТЕНИЕ ПРОЖАТИЮ БОТОМА ГРИГОРИЯ");
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            else if (call1.equals("МДА..."))
            {
             SendMessage message = new SendMessage();
             message.setChatId(chatId);
             message.setText("ЗАЧЕМ Я ПОДПИСАЛСЯ НА ЭТО...");


             SendMessage message2 = new SendMessage();
             message2.setChatId(chatId);
             message2.setText("ЛАДНО...");

             SendMessage time = new SendMessage();
             time.setChatId(chatId);


             SendMessage message3 = new SendMessage();
             message3.setChatId(chatId);
             message3.setText("ЛОВИ НАБОР РАДОСТИ, ЛЭГУШКС\n"
                     + " 🐸  🐸  🐸  🐸  🐸  🐸  🐸  🐸  🐸   \n"
                     + " 🐸  🐸  🐸  🐸  🐸  🐸  🐸  🐸  🐸   \n"
                     + " 🐸  🐸  🐸  🐸  🐸  🐸  🐸  🐸  🐸   \n"
                     + " 🐸  🐸  🐸  🐸  🐸  🐸  🐸  🐸  🐸   \n"
                     + " 🐸  🐸  🐸  🐸  🐸  🐸  🐸  🐸  🐸   \n"
                     + " 🐸  🐸  🐸  🐸  🐸  🐸  🐸  🐸  🐸   \n");

                InlineKeyboardMarkup inlineKeyboardMarkupPack = new InlineKeyboardMarkup();


                InlineKeyboardButton inlineKeyboardButtonFilmChoose1 = new InlineKeyboardButton();
                inlineKeyboardButtonFilmChoose1.setText("ФИЛЬМЫ");
                inlineKeyboardButtonFilmChoose1.setCallbackData("ВЫБОР ФИЛЬМА");

                InlineKeyboardButton inlineKeyboardButtonFilmChoose2 = new InlineKeyboardButton();
                inlineKeyboardButtonFilmChoose2.setText("ВТОРАЯ КНОПКА");
                inlineKeyboardButtonFilmChoose2.setCallbackData("НЕ РАБОТАЕТ");

                InlineKeyboard(message3, inlineKeyboardMarkupPack, inlineKeyboardButtonFilmChoose1, inlineKeyboardButtonFilmChoose2);


                try {
                    System.out.println(update.getCallbackQuery().getFrom().getFirstName() + " НАЖАЛ СЕКРЕТНУЮ КНОПКУ");
                    execute(message);
                    Thread.sleep(2000);
                    execute(message2);
                    Thread.sleep(2000);
                    for (int i = 10; i >= 0; i--) {
                        time.setText(String.valueOf(i));
                        execute(time);
                        Thread.sleep(1000);
                    }
                    Thread.sleep(1000);
                    execute(message3);

                } catch (TelegramApiException | InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (call1.equals("ВЫБОР ФИЛЬМА"))
            {
                SendMessage chooseFilm = new SendMessage();
                chooseFilm.setChatId(chatId);
                chooseFilm.setText("ВЫБЕРИ ФИЛЬМ");

                InlineKeyboardMarkup inlineKeyboardMarkupPackFilm = new InlineKeyboardMarkup();


                InlineKeyboardButton inlineKeyboard = new InlineKeyboardButton();
                inlineKeyboard.setText("ВЛАСТЕЛИН КОЛЕЦ");
                inlineKeyboard.setCallbackData("ВК");

                InlineKeyboardButton inlineKeyboard2 = new InlineKeyboardButton();
                inlineKeyboard2.setText("ГАРРИ ПОТТЕР");
                inlineKeyboard2.setCallbackData("ГАРРИ ПОТТЕР");

                InlineKeyboardButton inlineKeyboard3 = new InlineKeyboardButton();
                inlineKeyboard3.setText("ЗВЁЗДНЫЕ ВОЙНЫ");
                inlineKeyboard3.setCallbackData("ЗВЁЗДНЫЕ ВОЙНЫ");

                List<InlineKeyboardButton> rowInLinePackFilm = new ArrayList<>();
                rowInLinePackFilm.add(inlineKeyboard);

                List<InlineKeyboardButton> rowInLinePackFilm2 = new ArrayList<>();
                rowInLinePackFilm2.add(inlineKeyboard2);

                List<InlineKeyboardButton> rowInLinePackFilm3 = new ArrayList<>();
                rowInLinePackFilm3.add(inlineKeyboard3);


                List<List<InlineKeyboardButton>> rowLists = new ArrayList<>();
                rowLists.add(rowInLinePackFilm);
                rowLists.add(rowInLinePackFilm2);
                rowLists.add(rowInLinePackFilm3);

                inlineKeyboardMarkupPackFilm.setKeyboard(rowLists);
                chooseFilm.setReplyMarkup(inlineKeyboardMarkupPackFilm);

                try {
                    System.out.println(update.getCallbackQuery().getFrom().getFirstName() + " ВЫБИРАЕТ ФИЛЬМ");
                    execute(chooseFilm);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            switch (call1) {
                case "ВК":
                    ArrayList<String> vkFilming = new ArrayList<>();
                    vkFilming.add("https://youtu.be/7M_ll8Dk4g8");
                    vkFilming.add("https://youtu.be/WxDRk1miItE");
                    Collections.shuffle(vkFilming);

                    SendMessage vkFilm = new SendMessage();
                    vkFilm.setChatId(chatId);
                    vkFilm.setText(vkFilming.get(0));

                    try {
                        System.out.println(update.getCallbackQuery().getFrom().getFirstName()
                                + " ВЫБРАЛ КАТЕГОРИЮ: \"ВЛАСТЕЛИН КОЛЕЦ\"");
                        execute(vkFilm);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;
                case "ГАРРИ ПОТТЕР":
                    ArrayList<String> gpFilming = new ArrayList<>();
                    gpFilming.add("https://youtu.be/bxathpG7DTE?t=11");

                    Collections.shuffle(gpFilming);

                    SendMessage gpFilm = new SendMessage();
                    gpFilm.setChatId(chatId);
                    gpFilm.setText(gpFilming.get(0));

                    try {
                        System.out.println(update.getCallbackQuery().getFrom().getFirstName()
                                + " ВЫБРАЛ КАТЕГОРИЮ: \"ГАРРИ ПОТТЕР\"");
                        execute(gpFilm);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;
                case "ЗВЁЗДНЫЕ ВОЙНЫ":
                    ArrayList<String> swFilming = new ArrayList<>();
                    swFilming.add("https://youtu.be/vdEFIkmkRLg");

                    Collections.shuffle(swFilming);

                    SendMessage swFilm = new SendMessage();
                    swFilm.setChatId(chatId);
                    swFilm.setText(swFilming.get(0));

                    try {
                        System.out.println(update.getCallbackQuery().getFrom().getFirstName()
                                + " ВЫБРАЛ КАТЕГОРИЮ: \"ЗВЁЗДНЫЕ ВОЙНЫ\"");
                        execute(swFilm);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;
            }
            if (call1.equals("НЕ РАБОТАЕТ"))
            {
                SendMessage error = new SendMessage();
                error.setChatId(chatId);
                error.setText("КНОПКА НАХОДИТЬСЯ НА СТАДИИ: \"НЕТ ИДЕЙ, ПОДКИНЬТЕ ПЛЕЗ...\"");
                SendPhoto errPhoto = new SendPhoto();
                errPhoto.setChatId(chatId);
                errPhoto.setPhoto(new InputFile("https://ru.meming.world/images/ru/thumb/7/78/%D0%A8%D0%B0%D0%B1%D0%BB%D0%BE%D0%BD_%D0%BA%D0%BE%D1%82_3.jpg/300px-%D0%A8%D0%B0%D0%B1%D0%BB%D0%BE%D0%BD_%D0%BA%D0%BE%D1%82_3.jpg"));

                try {
                    execute(error);
                    Thread.sleep(1000);
                    execute(errPhoto);
                } catch (TelegramApiException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Ожидайте ответа от " + update.getCallbackQuery().getFrom().getFirstName()
                    + "...");

        }


    }

    public void InlineKeyboard(SendMessage message3, InlineKeyboardMarkup inlineKeyboardMarkupPack, InlineKeyboardButton inlineKeyboardButtonFilmChoose1, InlineKeyboardButton inlineKeyboardButtonFilmChoose2) {
        List<InlineKeyboardButton> rowInLinePack = new ArrayList<>();
        rowInLinePack.add(inlineKeyboardButtonFilmChoose1);
        rowInLinePack.add(inlineKeyboardButtonFilmChoose2);

        List<List<InlineKeyboardButton>> rowLists = new ArrayList<>();
        rowLists.add(rowInLinePack);

        inlineKeyboardMarkupPack.setKeyboard(rowLists);
        message3.setReplyMarkup(inlineKeyboardMarkupPack);
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

        File localFile = new File("D:/IDEAProjects/TelegramBot/resources/uploadfiles/" + fileName);

        InputStream is = new URL("https://api.telegram.org/file/bot" + getBotToken() + "/" + file_path).openStream();

        FileUtils.copyInputStreamToFile(is,localFile);

        br.close();
        is.close();

        System.out.println("Файл загружен\n");
        System.out.println("Путь файла: " + localFile.getAbsolutePath());

    }
}


