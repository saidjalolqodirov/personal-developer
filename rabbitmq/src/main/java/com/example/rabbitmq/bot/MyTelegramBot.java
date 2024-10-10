package com.example.rabbitmq.bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyTelegramBot extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "@newb_1212Bot";
    }

    @Override
    public String getBotToken() {
        return "7009112658:AAG-YYlUygbcxBn802IxV7zZEYy3Tk8gFY8";
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            Message message = update.getMessage();
            long chatId = message.getChatId();

            String response = "Sizning chat ID: " + chatId;
            sendMessage(chatId, response);
        }
    }

    public void sendMessage(long chatId, String text) {
        org.telegram.telegrambots.meta.api.methods.send.SendMessage message =
                new org.telegram.telegrambots.meta.api.methods.send.SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(text);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }
    }
}