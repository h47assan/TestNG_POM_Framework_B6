package Test;

import POM.HomePageElements;
import POM.LoginPageElements;
import POM.MyAccountPageElements;
import Utils.BaseDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _04_AddressBookFunctionTest extends BaseDriver {

    String expectedMessageAddNewAddress = "Your address has been successfully added";
    String expectedMessageEditTest = "Your address has been successfully updated";
    String expectedMessageDeleteTest = "Your address has been successfully deleted";

    HomePageElements homePageElements;
    LoginPageElements loginPageElements;
    MyAccountPageElements myAccountPageElements;

    @Test
    public void addNewAddressTest() {

        homePageElements = new HomePageElements(driver);
        loginPageElements = new LoginPageElements(driver);
        myAccountPageElements = new MyAccountPageElements(driver);

        homePageElements.myAccountButton.click();
        homePageElements.loginButton.click();

        loginPageElements.emailInput.sendKeys("test@technostudy.com");
        loginPageElements.passwordInput.sendKeys("Test12345..");
        loginPageElements.loginButton.click();

        String myAccountHeaderText = myAccountPageElements.myAccountHeader.getText();

        Assert.assertEquals(myAccountHeaderText, "My Account");

        myAccountPageElements.addressBookButton.click();
        myAccountPageElements.newAddressButton.click();

        myAccountPageElements.firstNameInput.sendKeys("Arya");
        myAccountPageElements.lastNameInput.sendKeys("Stark");
        myAccountPageElements.address1Input.sendKeys("200 Winterfell Road");
        myAccountPageElements.cityInput.sendKeys("North");
        myAccountPageElements.postalCodeInput.sendKeys("22222");

        Select selectCountry = new Select(myAccountPageElements.countryDropdown);
        selectCountry.selectByVisibleText("United States");

        Select selectState = new Select(myAccountPageElements.stateDropdown);
        selectState.selectByVisibleText("New York");

        myAccountPageElements.continueButton.click();

        Assert.assertTrue(myAccountPageElements.successMessage.isDisplayed());
        Assert.assertEquals(myAccountPageElements.successMessage.getText(), expectedMessageAddNewAddress);

    }

    @Test(dependsOnMethods = "addNewAddressTest")
    public void editAddressTest() {

        homePageElements = new HomePageElements(driver);
        loginPageElements = new LoginPageElements(driver);
        myAccountPageElements = new MyAccountPageElements(driver);

        homePageElements.myAccountButton.click();
        homePageElements.loginButton.click();

        loginPageElements.emailInput.sendKeys("test@technostudy.com");
        loginPageElements.passwordInput.sendKeys("Test12345..");
        loginPageElements.loginButton.click();

        String myAccountHeaderText = myAccountPageElements.myAccountHeader.getText();

        Assert.assertEquals(myAccountHeaderText, "My Account");

        myAccountPageElements.addressBookButton.click();

        int editButtonListSize = myAccountPageElements.editButtonsList.size();
        myAccountPageElements.editButtonsList.get(editButtonListSize-1).click();

        myAccountPageElements.address1Input.clear();
        myAccountPageElements.address1Input.sendKeys("450 Winterfell Road");

        myAccountPageElements.continueButton.click();

        Assert.assertTrue(myAccountPageElements.successMessage.isDisplayed());
        Assert.assertEquals(myAccountPageElements.successMessage.getText(), expectedMessageEditTest);

    }

    @Test(dependsOnMethods = "editAddressTest")
    public void deleteAddressTest() {

        homePageElements = new HomePageElements(driver);
        loginPageElements = new LoginPageElements(driver);
        myAccountPageElements = new MyAccountPageElements(driver);

        homePageElements.myAccountButton.click();
        homePageElements.loginButton.click();

        loginPageElements.emailInput.sendKeys("test@technostudy.com");
        loginPageElements.passwordInput.sendKeys("Test12345..");
        loginPageElements.loginButton.click();

        String myAccountHeaderText = myAccountPageElements.myAccountHeader.getText();

        Assert.assertEquals(myAccountHeaderText, "My Account");

        myAccountPageElements.addressBookButton.click();

        int deleteButtonListSize = myAccountPageElements.deleteButtonsList.size();
        myAccountPageElements.deleteButtonsList.get(deleteButtonListSize - 1).click();

        Assert.assertTrue(myAccountPageElements.successMessage.isDisplayed());
        Assert.assertEquals(myAccountPageElements.successMessage.getText(), expectedMessageDeleteTest);

    }

}
