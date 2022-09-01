package ru.netology.page;

import com.codeborne.selenide.ElementsCollection;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TransferPage {

    private static ElementsCollection buttonsAction = $$("[data-test-id=action-deposit]");
    private static ElementsCollection cards = $$(".list__item div");
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";

    public TransferPage() {
    }


    //public int cardBalance(int cardCount) {
    //    val text = cards.get(cardCount - 1).text();
    //    return extractBalance(text);
    //}

    //private int extractBalance(String text) {
    //    val start = text.indexOf(balanceStart);
    //    val finish = text.indexOf(balanceFinish);
    //    val value = text.substring(start + balanceStart.length(), finish);
    //    return Integer.parseInt(value);
    //}

    public static DashboardPage transferMoneyToCard(int cardOut,int amount) {

        //$(buttonsAction.get(cardCount - 1)).click();
        $("[data-test-id= amount] input")
                .setValue(String.valueOf(amount));
        $("[data-test-id=from] input")
                .setValue(String.valueOf(DataHelper.getCardNumber(cardOut)));
        $("[data-test-id=action-transfer]").click();

        return new DashboardPage();
    }
}