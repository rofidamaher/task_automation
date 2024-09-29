package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_login;
import org.example.pages.P03_loginforjumia;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


public class D03_loginforjumiaStepDef {

    P03_loginforjumia login = new P03_loginforjumia();

    @Given("user go to login page by click on login")
    public void login_page() throws InterruptedException {
        login.login().get(0).click();
        Thread.sleep(500);
        Hooks.driver.findElement(login.loginBtn()).click();
        Thread.sleep(500);

    }

    @When("user enter email {string} and click to submit btn")
    public void userEnterEmailAndClickToSubmitBtn(String arg0) throws InterruptedException {
        Hooks.driver.findElement(login.Email()).sendKeys(arg0);
        Hooks.driver.findElement(login.submitBtn()).click();
        Thread.sleep(500);
    }

    @And("user login with {string} and otp_target_display")
    public void userLoginWithAndOtp_target_display(String arg0) {
        Assert.assertEquals(Hooks.driver.findElement(login.otp_target_display()).getText(),arg0);
    }


    @When("popup open is display user click on newsletter_popup_close")
    public void popup_open_lIsDisplayUserClickOnNewsletter_popup_close() {
        Hooks.driver.findElement(login.newsletter_popup_close()).click();
    }
}
