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

    @Value
    public static class Card {
        String number;
    }

    static Card card1 = new Card("5559 0000 0000 0001");
    static Card card2 = new Card("5559 0000 0000 0002");

    public static String getCardNumber(int cardCount) {
        List<Card> cardsNumber = new ArrayList<>();
        cardsNumber.add(card1);
        cardsNumber.add(card2);
        return cardsNumber.get(cardCount - 1).getNumber();
    }
}
