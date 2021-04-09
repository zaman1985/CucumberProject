package stepDef;

import base.Config;
import base.TestData;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.Signup_page;

public class Signup_steps extends Config {
    Signup_page signUp=new Signup_page(driver);

    @And("I filled out the form with valid information")
    public void iFilledOutTheFormWithValidInformation() {
        signUp.inputFirstName();
        signUp.inputLastName();
        signUp.InputEmail();
        signUp.inputPassword();
        signUp.inputConPassword();
        signUp.inputDOB();
        signUp.pickMale();
    }

    @And("I clicked on agree checkbox")
    public void iClickedOnAgreeCheckbox() {
        signUp.selectCheckBox();
    }

    @When("I click Create My Account button")
    public void iClickCreateMyAccountButton() {
        signUp.clickOnSubmitButton();
    }

    @Then("I will verify Thank you message")
    public void iWillVerifyThankYouMessage() {
        signUp.thanksMessage();
    }
    @And("I will store the dynamic studentId")
    public void iWillStoreTheDynamicStudentId() {
        signUp.setStudentId();
        System.out.println("Ensure that student id are storage==="+ TestData.global_studentId);

    }
    @And("I click on Login Link")
    public void iClickOnLoginLink() {
        signUp.clickOnLoginLinkFromGnb();
    }


    @Then("I click on WebTable option from profile page")
    public void iClickOnWebTableOptionFromProfilePage() {
        signUp.clickOnWebTable();
    }
}

