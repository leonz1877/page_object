package ru.netology.test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.DashboardPage;
import ru.netology.page.LoginPage;
import ru.netology.page.TransferPage;

import static com.codeborne.selenide.Selenide.open;


class MoneyTransferTest {

    @BeforeEach
    void setup() {
        open("http://localhost:9999");
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void putMoneyCardOne() {
        int cardIn = 1;
        int cardOut = 2;
        int amount = 3000;

        var authInfo = DataHelper.getAuthInfo();
        var loginPage = LoginPage
                .validLogin(authInfo)
                .validVerify(DataHelper.getVerificationCodeFor(authInfo));
        int startBalanceIn = new DashboardPage().cardBalance(cardIn);
        int startBalanceOut = new DashboardPage().cardBalance(cardOut);
        var dashboardPage = DashboardPage.putMoneyToCard(cardIn);
        var transferPage = TransferPage.transferMoneyToCard(cardOut, amount);

        Assertions.assertEquals((startBalanceIn + amount), transferPage.cardBalance(cardIn));
        Assertions.assertEquals((startBalanceOut - amount), transferPage.cardBalance(cardOut));
    }

    @Test
    void putMoneyCardTwo() {
        int cardIn = 2;
        int cardOut = 1;
        int amount = 6000;

        var authInfo = DataHelper.getAuthInfo();
        var loginPage = LoginPage
                .validLogin(authInfo)
                .validVerify(DataHelper.getVerificationCodeFor(authInfo));
        int startBalanceIn = new DashboardPage().cardBalance(cardIn);
        int startBalanceOut = new DashboardPage().cardBalance(cardOut);
        var dashboardPage = DashboardPage.putMoneyToCard(cardIn);
        var transferPage = TransferPage.transferMoneyToCard(cardOut, amount);

        Assertions.assertEquals((startBalanceIn + amount), transferPage.cardBalance(cardIn));
        Assertions.assertEquals((startBalanceOut - amount), transferPage.cardBalance(cardOut));
    }
}
