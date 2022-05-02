package com.test.qic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

public class FirstTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void befor(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @Test
     public void test(){

        driver.navigate().to("https://lp.qic-insured.com/en");
        WebDriverWait wait = new WebDriverWait(driver, 30, 2000);

        WebElement itemCar = driver.findElement(By.xpath("//*[@id=\"landing-app\"]/div[1]/div[2]/div[1]/ul/li[1]/a/div"));
        itemCar.click();

        WebElement itemBrand = driver.findElement(By.xpath("//*[@id=\"landForm\"]/div/div[1]/div[1]"));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"landForm\"]/div/div[1]/div[1]"))); // проверка

        itemBrand.click();

        WebElement itemModel = driver.findElement(By.xpath("//label[contains(text(), '4Runner')]"));
        itemModel.click();

        try{
            Thread.sleep(5000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

        WebElement itemYear = driver.findElement(By.xpath("//div[@chip=2019]"));
        itemYear.click();

        setValue("555555");

        driver.quit();

     }

    public void setValue(String value){
        String fieldXPath = "//input[@type='text']";
        WebElement element = driver.findElement(By.xpath(fieldXPath));
        element.click();
        element.sendKeys(value);
    }

}
