package base;

import io.cucumber.java.After;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

public class Utillity extends Config{

    public void dropdownByXpathUsingValue(String loc,String value){
        Select se=new Select(driver.findElement(By.xpath(loc)));
        se.selectByValue(value);

    }
    public void dropdownByValue(WebElement element,String value){
        Select se=new Select(element);
        se.selectByValue(value);
    }
    public void dropdownByVisibleText(WebElement element,String value){
        Select se=new Select(element);
        se.selectByVisibleText(value);
    }
    public void dropdownByIndexNumber(WebElement element,int indexNum){
        Select se=new Select(element);
        se.selectByIndex(indexNum);
    }
    // ============== radio-button
//        public void radioButton (String locator, int x){
//        List<WebElement> radioButtons = driver.findElements (By.xpath(locator));
//        radioButtons.get(x).click();
//    }

    @After
    public static void Screenshot(WebDriver driver, String Screenshot) {
        try {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File src = screenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File("src/test/screenshot" + Screenshot+ ".png"));
            System.out.println("Successfully take screenshot");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}

