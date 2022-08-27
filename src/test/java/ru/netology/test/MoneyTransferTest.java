package ru.netology.test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.DashboardPage;
import ru.netology.page.LoginPageV1;
import ru.netology.page.LoginPageV2;

import static com.codeborne.selenide.Selenide.open;


class MoneyTransferTest {

    @BeforeEach
    void setup() {
        open("http://localhost:9999");
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void putMoneyCardOne() {
        int cardCount = 1;
        int amount = 3000;

        var authInfo = DataHelper.getAuthInfo();
        new LoginPageV2()
                .validLogin(authInfo)
                .validVerify(DataHelper.getVerificationCodeFor(authInfo));
        int startbalance = new DashboardPage().CardBalance(cardCount);
        var Dashboardpage = ru.netology.page.DashboardPage.putMoneyToCard(cardCount, amount);

        Assertions.assertEquals((startbalance + amount), Dashboardpage.CardBalance(cardCount));
    }

    @Test
    void putMoneyCardTwo() {
        int cardCount = 2;
        int amount = 6000;

        var authInfo = DataHelper.getAuthInfo();
        new LoginPageV1()
                .validLogin(authInfo)
                .validVerify(DataHelper.getVerificationCodeFor(authInfo));
        int startbalance = new DashboardPage().CardBalance(cardCount);
        var Dashboardpage = ru.netology.page.DashboardPage.putMoneyToCard(cardCount, amount);

        Assertions.assertEquals((startbalance + amount), Dashboardpage.CardBalance(cardCount));
    }


}
