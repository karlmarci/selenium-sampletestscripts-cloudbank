package Testcases;

import android.util.Log;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Config.AppConfig;
import Controller.ChromeDriverController;
import Core.BaseTest;
import View.LoginPage;

public class LoginTest extends BaseTest {

    protected static LoginPage loginPage;
    final String headerLink = "https://cloudvr.pythonanywhere.com/bank/about";

    @BeforeClass
    public static void initialize()
    {
        loginPage = new LoginPage();
    }


    @Test(priority = 0)
    public void check_welcome_text()
    {
        Assert.assertEquals(loginPage.getWelcomeText(),"Welcome to Cloud Bank");
            System.out.println(loginPage.getWelcomeText());
    }

    @Test(priority = 1)
    public void check_username_password_display()
    {
        Assert.assertTrue(loginPage.getUsernameDisplayed());
            System.out.println(loginPage.getUsernameDisplayed());
        Assert.assertTrue(loginPage.getPasswordDisplayed());
            System.out.println(loginPage.getPasswordDisplayed());
    }

    @Test(priority = 2)
    public void check_username_password_placeholder()
    {
        Assert.assertEquals(loginPage.getUsernamePlaceholder(),"Enter Username...");
            System.out.println(loginPage.getUsernamePlaceholder());
        Assert.assertEquals(loginPage.getPasswordPlaceholder(),"Password");
            System.out.println(loginPage.getPasswordPlaceholder());
    }


    @Test(priority = 3)
    public void check_loginButton_display()
    {
        Assert.assertTrue(loginPage.getLoginButtonDisplayed());
            System.out.println(loginPage.getLoginButtonDisplayed());
        Assert.assertEquals(loginPage.getLoginText(), "Log in");
            System.out.println(loginPage.getLoginText());
    }

    @Test(priority = 4)
    public void check_aboutAppLink_display()
    {
        Assert.assertEquals(loginPage.getAboutTheAppLink(), "About the App");
            System.out.println(loginPage.getAboutTheAppLink());
    }

    @Test(priority = 5)
    public void check_onlyUsernameCredential() {
        loginPage.setLoginForm("123","")
                .clickLogin();
            Assert.assertEquals(loginPage.getPasswordErrorMessage(),"Please fill out this field.");
                System.out.println(loginPage.getPasswordErrorMessage());
        loginPage.clearUsername();
    }

    @Test(priority = 6)
    public void check_onlyPasswordCredential()
    {
        loginPage.setLoginForm("","123")
                .clickLogin();
            System.out.println(loginPage.getUsernameErrorMessage());
        loginPage.clearPassword();
    }

    @Test(priority = 7)
    public void check_validCredential()
    {
        loginPage.setLoginForm("tester","password@1234")
                .clickLogin();
        Assert.assertEquals(ChromeDriverController.getWebDriver().getCurrentUrl(), headerLink);
            System.out.println(ChromeDriverController.getWebDriver().getCurrentUrl());
    }

//    @BeforeClass
//    public void check_aboutApp_redirect()
//    {
//        loginPage.clickAboutTheApp();
//          Assert.assertEquals(ChromeDriverController.getWebDriver().getCurrentUrl(), headerLink);
//              System.out.println(ChromeDriverController.getWebDriver().getCurrentUrl());
//    }

}
