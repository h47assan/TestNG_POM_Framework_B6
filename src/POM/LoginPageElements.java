package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageElements {

    public LoginPageElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "input-email")
    public WebElement emailInput;

    @FindBy(id = "input-password")
    public WebElement passwordInput;

    @FindBy(css = "input[value='Login']")
    public WebElement loginButton;

    @FindBy(css = "div[class='alert alert-danger alert-dismissible']")
    public WebElement errorMessage;

}
