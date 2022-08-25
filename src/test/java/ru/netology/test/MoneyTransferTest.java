package ru.netology.test;

import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.LoginPageV1;
import ru.netology.page.LoginPageV2;
import ru.netology.page.LoginPageV3;

import static com.codeborne.selenide.Selenide.open;


class MoneyTransferTest {

    @Test
    void shoulTransferMoneyBetweenOwnCardV1(){
        open("http://localhost:9999");
        var authInfo = DataHelper.getAuthInfo();
        new LoginPageV1()
                .validLogin(authInfo)
                .validVerify(DataHelper.getVerificationCodeFor(authInfo));
    }

    @Test
    void shoulTransferMoneyBetweenOwnCardV2(){
        open("http://localhost:9999");
        var authInfo = DataHelper.getAuthInfo();
        new LoginPageV2()
                .validLogin(authInfo)
                .validVerify(DataHelper.getVerificationCodeFor(authInfo));
    }

    @Test
    void shoulTransferMoneyBetweenOwnCardV3(){
        open("http://localhost:9999");
        var authInfo = DataHelper.getAuthInfo();
        new LoginPageV3()
                .validLogin(authInfo)
                .validVerify(DataHelper.getVerificationCodeFor(authInfo));
    }
}
