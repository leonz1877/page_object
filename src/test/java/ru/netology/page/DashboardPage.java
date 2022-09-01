package ru.netology.page;

import com.codeborne.selenide.ElementsCollection;
import lombok.val;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {

    private static ElementsCollection buttonsAction = $$("[data-test-id=action-deposit]");
    private static ElementsCollection cards = $$(".list__item div");
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";

    public DashboardPage() {
    }

    public int cardBalance(int cardCount) {
        val text = cards.get(cardCount - 1).text();
        return extractBalance(text);
    }

    private int extractBalance(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }

    public static TransferPage putMoneyToCard(int cardCount) {
        $(buttonsAction.get(cardCount - 1)).click();

        return new TransferPage();
    }
}