package pageObject;

import base.Config;
import base.TestData;
import base.Utillity;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.jar.JarEntry;

public class Signup_page extends Config {
    Faker faker=new Faker();
    Utillity utill=new Utillity();

    public Signup_page(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(how= How.NAME,using = "firstName")
    public WebElement firstName;

    @FindBy(how=How.NAME,using = "lastName")
    public WebElement lastName;

    @FindBy(how=How.NAME,using = "email")
    public WebElement email;

    @FindBy(how=How.NAME,using = "password")
    public WebElement password;

    @FindBy(how=How.NAME,using = "confirmPassword")
    public WebElement confirmPassword;

    @FindBy(how=How.NAME,using = "month")
    public WebElement month;

    @FindBy(how=How.NAME,using = "day")
    public WebElement day;

    @FindBy(how=How.NAME,using = "year")
    public WebElement year;

    @FindBy(how = How.XPATH, using ="//input[@type='radio']")
    public WebElement radioButton;

    @FindBy(how=How.ID,using = "male")
    public WebElement male;

    @FindBy(how=How.ID,using = "female")
    public WebElement female;

    @FindBy(how=How.ID,using = "defaultCheck1")
    public WebElement checkbox;

    @FindBy(how=How.XPATH,using = "//*[@type='submit']")
    public WebElement submitButton;

    @FindBy(how=How.XPATH,using = "//*[@id=\"success_message\"]/div")
    public WebElement successMessage;

    @FindBy(how=How.XPATH,using = "//*[@id=\"success_message\"]/div")
    public WebElement studentId;

    @FindBy(how=How.XPATH,using = "//a[@href='http://qa.taltektc.com/home/login']")
    public WebElement loginLinkFromGnb;

    @FindBy(how=How.XPATH,using = "//*[@href='http://qa.taltektc.com/home/web_table']")
    public WebElement clickWebTable;


    public void inputFirstName(){
        TestData.global_studentFirstName=faker.name().firstName();
        firstName.sendKeys(global_studentFirstName);
        System.out.println("Student First Name Is===="+faker.name().firstName());
    }
    public void inputLastName(){
        TestData.global_studentLastName=faker.name().lastName();
        lastName.sendKeys(global_studentLastName);
        System.out.println("Student Last Name Is===="+faker.name().lastName());
    }
    public void InputEmail(){
        TestData.global_studentEmail=faker.internet().emailAddress();
        email.sendKeys(TestData.global_studentEmail);
        System.out.println("Student Email Is===="+faker.internet().emailAddress());
    }
    public void inputPassword(){
        password.sendKeys(global_studentPassword);
    }
    public void inputConPassword(){
        confirmPassword.sendKeys(global_studentConfirmPassword);
    }
    public void inputDOB(){
        utill.dropdownByVisibleText(month,"Dec");
        utill.dropdownByVisibleText(day,"20");
        utill.dropdownByVisibleText(year,"1985");
    }
    public void pickMale(){
        male.click();

    }
    public void selectCheckBox(){
        checkbox.click();
    }
    public void clickOnSubmitButton(){
        submitButton.click();
    }
    public void thanksMessage(){

        String exp="Thank you for sign up";
        String actual=successMessage.getText().substring(0,21);
        System.out.println("Actual message is=>"+actual);
        Assert.assertEquals(actual,exp);
    }
    public void setStudentId(){
        TestData.global_studentId=studentId.getText().substring(38);
    }
    public void clickOnLoginLinkFromGnb(){
        loginLinkFromGnb.click();
    }
public void clickOnWebTable(){
        clickWebTable.click();
}
}
