package ru.netology.data;

import lombok.Value;

import java.util.ArrayList;
import java.util.List;

public class DataHelper {
    private DataHelper() {
    }

    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    @Value
    public static class VerificationCode {
        private String code;
    }

    public static VerificationCode getVerificationCodeFor(AuthInfo authInfo) {
        return new VerificationCode("12345");
    }

    //@Value
    //public static class Card {
    //    private String number;
    //}

    public static String getCardNumber(int cardCount) {
        List<String> cardsNumber = new ArrayList<>();
        cardsNumber.add("5559 0000 0000 0001");
        cardsNumber.add("5559 0000 0000 0002");
        return cardsNumber.get(cardCount);
    }
}
