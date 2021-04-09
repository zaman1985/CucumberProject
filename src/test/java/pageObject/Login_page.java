package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Login_page {
    public Login_page(WebDriver driver){
        PageFactory.initElements(driver,this);

    }
@FindBy(how= How.NAME,using = "email")
    public WebElement enterEmailorId;

    @FindBy(how=How.NAME,using = "password")
    public WebElement password;

    @FindBy(how=How.XPATH,using = "//input[@type='submit']")
    public WebElement login;

    @FindBy(how=How.XPATH,using ="//*[@id=\"error_message\"]/div/h5")
    public WebElement InvalidEmailErrorMessage;

    @FindBy(how=How.XPATH,using = "//*[@class='new-account']")
    public WebElement clickOnCreateAccountButton;


    public void setEnterEmailOrId(String studentEmail){
        enterEmailorId.sendKeys(studentEmail);
    }
    public void enterPassword(String studentPassword){
        password.sendKeys(studentPassword);
    }
    public void clickOnLoginButton(){
        login.click();

    }
    public void clickOnCreateAccount(){
        clickOnCreateAccountButton.click();
    }
    public void invalidErrorMessage(){
        String exp="You have entered an incorrect email or student Id.";
        String actual=InvalidEmailErrorMessage.getText().substring(1);
        System.out.println(actual);
        Assert.assertEquals(actual,exp);
    }
}

