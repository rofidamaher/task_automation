package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P02_login {
//    public P02_login()
//    {
//        PageFactory.initElements(Hooks.driver,this);
//    }
    public By login_page()
    {
        return (By.className("ico-login"));
    }

    public By Email()
    {
        return (By.id("login-email"));
    }

    public By Password()
    {
        return (By.id("login-password"));
    }
    public By btn_login()
    {
        return (By.xpath("//button[@type='submit']"));
    }

    public By error_message()
    {
        return (By.xpath("//div[@class='message-error validation-summary-errors']"));
    }

    public By my_account()
    {
        return (By.xpath("//a[@class='ico-account']"));
    }


//    @FindBy(className = "ico-login")
//    public WebElement login_page;
//
//    @FindBy(id = "Email")
//    public WebElement Email;
//
//    @FindBy(id = "Password")
//    public WebElement Password;
//
//    @FindBy(className = "button-1 login-button")
//    public WebElement btn_login;

//    @FindBy(className = "message-error validation-summary-errors")
//    public WebElement error_message;



}
