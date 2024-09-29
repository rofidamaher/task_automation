package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.apache.poi.ss.usermodel.*;
import org.example.pages.P04_Search;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;


public class D04_searchStepDef {

   P04_Search search = new P04_Search();
    WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(5));

    @When("user enter {string} in search and press enter")
    public void userEnterInSearchAndPressEnter(String arg0) {
        Hooks.driver.findElement(search.Search_field()).sendKeys(arg0);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
         search.Search_items().get(0).click();
    }

    @And("user find {int} products then write in excel file")
    public void userFindProductThenWriteInExclFile(int arg0) {
        wait.until(ExpectedConditions.visibilityOf( search.pro_Name().get(0)));


        Workbook workbook = null;
        try {
            workbook = WorkbookFactory.create(
                    new FileInputStream(
                            System.getProperty("user.dir") +"\\src\\main\\resources\\file.xlsx"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Sheet sheet = workbook.getSheetAt(0);
        Row row1  ;
        Cell cell1 ,cell2 ;
        row1 = sheet.createRow(0);
        cell1 = row1.createCell(0);
        cell2 = row1.createCell(1);

        cell1.setCellValue("Name");
        cell2.setCellValue("Price");




        for(int i = 1 ; i <= arg0 ; i++){
            System.out.println(search.pro_Name().get(i).getText());
            System.out.println(search.pro_Price().get(i).getText());
            row1 = sheet.createRow(i);
             cell1 = row1.createCell(0);
             cell2 = row1.createCell(1);

            cell1.setCellValue(search.pro_Name().get(i).getText());
            cell2.setCellValue(search.pro_Price().get(i).getText());

        }
        try {
            workbook.write(new FileOutputStream(System.getProperty("user.dir") +"\\src\\main\\resources\\file.xlsx"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Close the Workbook object
        try {
            workbook.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
