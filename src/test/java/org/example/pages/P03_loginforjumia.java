package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P03_loginforjumia {
    public List<WebElement> login()
    {

        List<WebElement> items = Hooks.driver.findElements(By.xpath("//div[@class='dpdw _pcent']//label//span"));
    return items;
    }
    public By loginBtn()
    {
        return (By.xpath("//div[@class='inbox']//a[@class='btn _prim -fw _md']"));
    }

    public By submitBtn()
    {
        return (By.xpath("//button[@type='submit']"));
    }


    public By Email()
    {
        return (By.id("input_identifierValue"));
    }



    public By otp_target_display()
    {
        return (By.id("otp_target_display"));
    }
    public By newsletter_popup_close()
    {
        return (By.xpath("//button[@class='cls']"));
    }


}
