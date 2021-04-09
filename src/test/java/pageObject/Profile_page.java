package pageObject;

import base.Config;
import base.TestData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Profile_page extends Config {
    public Profile_page(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(how= How.XPATH,using = "//*[@id='profile_form']/h5")
    public WebElement verifyHomepage;

    @FindBy(how= How.NAME,using = "firstName")
    public WebElement verifyFirstName;

    @FindBy(how=How.NAME,using = "lastName")
    public WebElement verifyLastName;

    @FindBy(how=How.NAME,using = "email")
    public WebElement verifyEmail;

    public void setVerifyHomepage(){
        String exp="Update Profile";
        String actual= verifyHomepage.getText();
        System.out.println(actual);
        Assert.assertEquals(actual,exp);
    }
    public void verifyStudentInfo(){
        Assert.assertEquals(verifyFirstName.getAttribute("value"), TestData.global_studentFirstName);
        Assert.assertEquals(verifyLastName.getAttribute("value"),TestData.global_studentLastName);
        Assert.assertEquals(verifyEmail.getAttribute("value"),TestData.global_studentEmail);
    }
}
