package View;

import android.util.Log;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Controller.ChromeDriverController;
import Core.BasePage;
import Model.ElementLocatorModel;

public class LoginPage extends BasePage {

    //Elements

    private WebElement getWelcomeTextElement()
    {
        return ElementLocatorModel.findElementByXPath("//*[(text()='Welcome to Cloud Bank')]");
    }

    private WebElement getUsernameElement()
    {
        return ElementLocatorModel.findElementById("exampleInputUsername");
    }

    private WebElement getPasswordElement()
    {
        return ElementLocatorModel.findElementById("exampleInputPassword");
    }

    private WebElement getLoginButtonElement()
    {
        return ElementLocatorModel.findElementByXPath("//input[@value='Log in']");
    }

    private WebElement getAboutTheAppLinkElement()
    {
        return ElementLocatorModel.findElementByXPath("//a[contains(text(),'About the App')]");
    }


    //Values

    public String getWelcomeText()
    {
        return this.getWelcomeTextElement().getText();
    }

    public String getUsernamePlaceholder()
    {
        return this.getUsernameElement().getAttribute("placeholder");
    }

    public String getUsernameErrorMessage()
    {
        return this.getUsernameElement().getAttribute("validationMessage");
    }

    public String getPasswordPlaceholder()
    {
        return this.getPasswordElement().getAttribute("placeholder");
    }

    public String getPasswordErrorMessage()
    {
        return this.getPasswordElement().getAttribute("validationMessage");
    }

    public String getLoginText()
    {
        return this.getLoginButtonElement().getAttribute("value");
    }

    public Boolean getUsernameDisplayed()
    {
        return this.getUsernameElement().isDisplayed();
    }

    public Boolean getPasswordDisplayed()
    {
        return this.getPasswordElement().isDisplayed();
    }

    public Boolean getLoginButtonDisplayed()
    {
        return this.getLoginButtonElement().isDisplayed();
    }

    public String getAboutTheAppLink()
    {
        return this.getAboutTheAppLinkElement().getText();
    }


    //Actions

    public void clickAboutTheApp()
    {
        this.getAboutTheAppLinkElement().click();
    }

    public void clickLogin()
    {
        this.getLoginButtonElement().click();
    }

    public void clearUsername()
    {
        this.getUsernameElement().clear();
    }

    public void clearPassword()
    {
        this.getPasswordElement().clear();
    }

    public LoginPage setLoginForm(String username, String password)
    {
        this.getUsernameElement().sendKeys(username);
        this.getPasswordElement().sendKeys(password);
        return this;
    }

}
