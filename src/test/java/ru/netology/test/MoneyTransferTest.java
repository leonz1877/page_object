package ru.netology.test;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.LoginPage;

import static com.codeborne.selenide.Selenide.open;


class MoneyTransferTest {

    @Test
    void putMoneyCardOne() {
        int cardIn = 1;
        int cardOut = 2;
        int amount = 3000;

        var loginpage = open("http://localhost:9999", LoginPage.class);
        var authInfo = DataHelper.getAuthInfo();
        var verifacationPage = loginpage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        var dashboardPage = verifacationPage.validVerify(verificationCode);
        int startBalanceIn = dashboardPage.cardBalance(cardIn);
        int startBalanceOut = dashboardPage.cardBalance(cardOut);
        var transfertPage = dashboardPage.putMoneyToCard(cardIn);
        dashboardPage = transfertPage.transferMoneyToCard(cardOut, amount);

        Assertions.assertEquals((startBalanceIn + amount), dashboardPage.cardBalance(cardIn));
        Assertions.assertEquals((startBalanceOut - amount), dashboardPage.cardBalance(cardOut));
    }

    @Test
    void putMoneyCardTwo() {
        int cardIn = 2;
        int cardOut = 1;
        int amount = 6000;

        var loginpage = open("http://localhost:9999", LoginPage.class);
        var authInfo = DataHelper.getAuthInfo();
        var verifacationPage = loginpage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        var dashboardPage = verifacationPage.validVerify(verificationCode);
        int startBalanceIn = dashboardPage.cardBalance(cardIn);
        int startBalanceOut = dashboardPage.cardBalance(cardOut);
        var transfertPage = dashboardPage.putMoneyToCard(cardIn);
        dashboardPage = transfertPage.transferMoneyToCard(cardOut, amount);

        Assertions.assertEquals((startBalanceIn + amount), dashboardPage.cardBalance(cardIn));
        Assertions.assertEquals((startBalanceOut - amount), dashboardPage.cardBalance(cardOut));
    }
}
