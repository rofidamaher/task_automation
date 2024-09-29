package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P04_Search {

    public By Search_field()
    {
        return (By.id("twotabsearchtextbox"));
    }
    public List<WebElement> Search_items()
    {
        List<WebElement> items = Hooks.driver.findElements(By.className("s-suggestion-container"));
        return items;
    }
    public List<WebElement> pro_Name()
    {
        List<WebElement> items = Hooks.driver.findElements(By.xpath("//div[@data-cy='title-recipe']//h2"));
        return items;
    }
    public List<WebElement> pro_Price()
    {
        List<WebElement> items = Hooks.driver.findElements(By.xpath("//div[@data-cy='price-recipe']//span[@class='a-price-whole']"));
        return items;
    }



}
