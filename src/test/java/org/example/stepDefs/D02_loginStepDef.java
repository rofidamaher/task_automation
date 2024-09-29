package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_login;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;


public class D02_loginStepDef {

    P02_login login = new P02_login();

    @Given("user go to login page")
    public void login_page() throws InterruptedException {
        Hooks.driver.findElement(login.login_page()).click();
        Thread.sleep(2000);
    }

    @When("user login with email {string} and password {string}")
    public void userLoginWithValidEmailAnd(String arg0, String arg1) {
        Hooks.driver.findElement(login.Email()).sendKeys(arg0);
        Hooks.driver.findElement(login.Password()).sendKeys(arg1);
    }

    @And("user press on login button")
    public void userPressOnLoginButton() {
        //login.Password().sendKeys(Keys.ENTER);
        Hooks.driver.findElement(login.btn_login()).click();
    }

    @Then("user login to the system successfully")
    public void userLoginToTheSystemSuccessfully() {
        // Soft Assertion
        SoftAssert soft = new SoftAssert();
//        //first Assert
//        String expectedResult = "My account";
//        String actualResult =login.my_account().getText();
//        System.out.println(actualResult);
//        soft.assertEquals(actualResult.contains(expectedResult),true);
//        soft.assertTrue(actualResult.contains(expectedResult),"user can login successful" );

        //Hooks.driver.getCurrentUrl();
       // second Assert

        String expectedResulturl = "http://149.102.143.225:5001/";
        String actualResulturl =Hooks.driver.getCurrentUrl();
        System.out.println(actualResulturl);
        soft.assertTrue(actualResulturl.contains(expectedResulturl),"user can login successful" );

        // Assert All
        soft.assertAll();
    }

    @Then("user could not login to the system")
    public void userCouldNotLoginToTheSystem() {
        // Soft Assertion
        SoftAssert soft = new SoftAssert();
        //first Assert
        String expectedResult = "Login was unsuccessful";
        String actualResult =Hooks.driver.findElement(login.error_message()).getText();
        System.out.println(actualResult);
        soft.assertEquals(actualResult.contains(expectedResult),true);
        soft.assertTrue(actualResult.contains(expectedResult),"user can't login " );
//        // second Assert

        String expectedResultcolor = "#e4434b";
        String actualResultcolor =Hooks.driver.findElement(login.error_message()).getCssValue("color");
        String expectedColor = Color.fromString(actualResultcolor).asHex();

        System.out.println(actualResultcolor);
        System.out.println(expectedColor);
        soft.assertTrue(expectedColor.contains(expectedResultcolor));

        // Assert All
        soft.assertAll();
    }
}
