package ru.netology.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TransferPage {
    private ElementsCollection buttonsAction = $$("[data-test-id=action-deposit]");
    private ElementsCollection cards = $$(".list__item div");
    private SelenideElement amountField = $("[data-test-id=amount] input");
    private SelenideElement cardOutField = $("[data-test-id=from] input");
    private SelenideElement transferButton = $("[data-test-id=action-transfer]");

    public TransferPage() {
    }

    public DashboardPage transferMoneyToCard(int cardOut, int amount) {
        amountField.setValue(String.valueOf(amount));
        cardOutField.setValue(String.valueOf(DataHelper.getCardNumber(cardOut)));
        transferButton.click();
        return new DashboardPage();
    }
}