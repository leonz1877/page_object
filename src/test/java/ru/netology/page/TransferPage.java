package ru.netology.page;

import com.codeborne.selenide.ElementsCollection;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TransferPage {

    private static ElementsCollection buttonsAction = $$("[data-test-id=action-deposit]");
    private static ElementsCollection cards = $$(".list__item div");

    public TransferPage() {
    }

    public static DashboardPage transferMoneyToCard(int cardOut, int amount) {

        $("[data-test-id= amount] input")
                .setValue(String.valueOf(amount));
        $("[data-test-id=from] input")
                .setValue(String.valueOf(DataHelper.getCardNumber(cardOut)));
        $("[data-test-id=action-transfer]").click();

        return new DashboardPage();
    }
}