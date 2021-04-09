package pageObject;

import base.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Webtable_handeling extends Config {
    public Webtable_handeling(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void webtableHandeling() {

//        List<WebElement> row = driver.findElements(By.xpath("//*[@id=\"page-content-wrapper\"]/div/table/tbody/tr"));
//        int rowsize = row.size();
//        System.out.println("total row size is===" + rowsize);


        List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"page-content-wrapper\"]/div/table/tbody/tr"));
        System.out.println(rows.size());
        String beforeXpath = "//*[@id=\"page-content-wrapper\"]/div/table/tbody/tr[";
        String afterXpath = "]/td[1]";

        for (int i = 1; i <= rows.size(); i++) {
            String actualXpath = beforeXpath + i + afterXpath;
            WebElement element = driver.findElement(By.xpath(actualXpath));
            // System.out.println(element.getText());

            if (element.getText().contains(global_studentFirstName)) {
                System.out.println(element.getText());
                break;
            }
        }

        ////*[@id="page-content-wrapper"]/div/table/tbody/tr[1]/td[2]
        String afterXpathLastname = "]/td[2]";
        for (int i = 1; i <= rows.size(); i++) {
            String actualXpath = beforeXpath + i + afterXpathLastname;
            WebElement element = driver.findElement(By.xpath(actualXpath));
            //System.out.println(element.getText());
            if (element.getText().contains(global_studentLastName)) {
                System.out.println(element.getText());
                break;
            }

        }


        ////*[@id="page-content-wrapper"]/div/table/tbody/tr[1]/td[3]
        String eMailXpath = "]/td[3]";
        for (int i = 1; i <= rows.size(); i++) {
            String actualXpath = beforeXpath + i + eMailXpath;
            WebElement element = driver.findElement(By.xpath(actualXpath));
            //System.out.println(element.getText());
            if (element.getText().contains(global_studentEmail)) {
                System.out.println(element.getText());
                break;


            }


        }
    }
}