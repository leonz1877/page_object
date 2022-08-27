package ru.netology.page;

import com.codeborne.selenide.ElementsCollection;
import lombok.val;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {

    private static ElementsCollection buttonsAction = $$("[data-test-id=action-deposit]");
    private static ElementsCollection cards = $$(".list__item div");
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";

    public DashboardPage() {
    }

    public int CardBalance(int cardCount) {
        val text = cards.get(cardCount - 1).text();
        return extractBalance(text);
    }

    private int extractBalance(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }

    public static DashboardPage putMoneyToCard(int cardCount, int amount) {
        $(buttonsAction.get(cardCount - 1)).click();
        $("[data-test-id= amount] input").setValue(String.valueOf(amount));
        String where;
        if (cardCount == 1) {
            where = String.valueOf(1);
        } else where = String.valueOf(0);
        $("[data-test-id=from] input").setValue(DataHelper.getCardNumber(Integer.parseInt(where)));
        $("[data-test-id=action-transfer]").click();

        return new DashboardPage();
    }
}