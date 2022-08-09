package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPageElements {

    public MyAccountPageElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[text()='My Account']")
    public WebElement myAccountHeader;

    @FindBy(xpath = "//a[text()='Newsletter']")
    public WebElement newsletterButton;

    @FindBy(xpath = "(//input[@name='newsletter'])[1]")
    public WebElement subscribeYesRadioButton;

    @FindBy(xpath = "(//input[@name='newsletter'])[2]")
    public WebElement subscribeNoRadioButton;

    @FindBy(css = "input[value='Continue']")
    public WebElement continueButton;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    public WebElement successMessage;

    @FindBy(xpath = "//a[text()='Edit Account']")
    public WebElement editAccountButton;

    @FindBy(id = "input-firstname")
    public WebElement firstNameInput;

    @FindBy(id = "input-lastname")
    public WebElement lastNameInput;

}
