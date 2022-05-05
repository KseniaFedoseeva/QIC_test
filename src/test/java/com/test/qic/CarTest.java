package com.test.qic;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CarTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void befor() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 40, 2000);


    }

    @Test
    public void test() {

        driver.navigate().to("https://lp.qic-insured.com/en");


        //Переход в car

        WebElement itemCar = driver.findElement(By.xpath("//div[@class = 'offerMain__insurance-item car']"));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        itemCar.click();

        //Выбор бренда

        WebElement itemBrand = driver.findElement(By.xpath("//p[text() = 'Toyota']"));
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text() = 'Toyota']"))); // проверка
        itemBrand.click();

        //Выбор модели

        WebElement itemModel = driver.findElement(By.xpath("//label[contains(text(), '4Runner')]"));
        itemModel.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Выбор года
        String year = "//div[@chip=2012]";
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement itemYear = driver.findElement(By.xpath(year));
        itemYear.click();

        //Заполнение данных об автомобиле

        setValue("555555");
        clickProceed();

        WebElement seats = driver.findElement(By.xpath("//label[text() = '6 ']"));
        seats.click();

        WebElement cylinders = driver.findElement(By.xpath("//label[@for = 'inbound_radio_8']"));
        cylinders.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath(year)).click();
       // itemYear.click();

        setValue("5555555555555555D");
        clickProceed();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setValue("23333333333");
        clickProceed();

        WebElement firstName = driver.findElement(By.xpath("//label[text() = 'First Name']"));

        Actions action = new Actions (driver);
        action.moveToElement(firstName);
        action.click(firstName);
        action.sendKeys(firstName, "Anna").perform();

        WebElement familyName = driver.findElement(By.xpath("//label[text() = 'Family Name']"));
      //  Actions action1 = new Actions (driver);
        action.moveToElement(familyName);
        action.click(familyName);
        action.sendKeys(familyName, "Anna").perform();

        clickProceed();


      // Страница дня рождения
        WebElement titlePage = driver.findElement(By.xpath("//h1[@class='boxForm_heading']"));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        clickProceed();

        // Страница даты полиса
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickProceed();

        //Контакты

        WebElement contacts = driver.findElement(By.xpath("/html/body/section/section[1]/div/div[3]/div[2]/div/form/div[1]/div[1]/div/div[2]"));
        action.moveToElement(contacts).click(contacts);
        action.sendKeys(contacts, "1520 1122").perform();

        WebElement email = driver.findElement(By.xpath("/html/body/section/section[1]/div/div[3]/div[2]/div/form/div[1]/div[2]/input"));
        action.moveToElement(email).click(email);
        action.sendKeys(email, "15201122@bk.ru").perform();

        clickProceed();

        //Выбор плана Заголовок //h1[text() = ' Select Insurance Type ']

        WebElement select = driver.findElement(By.xpath("/html/body/section/section[1]/div/div[2]/div[2]/div/div[2]/div[2]/div/div[2]/a"));
        WebElement selectTitle = driver.findElement(By.xpath("//h1[text() = ' Select Insurance Type ']"));
        Assert.assertTrue("Страница не загрузилась", selectTitle.isDisplayed());
        select.click();

        //Указываем стоимость авто Подзаголовок //p[text() = 'The average market price, including depreciation']

        WebElement valueCar = driver.findElement(By.xpath("p[text() = 'The average market price, including depreciation']"));
        Assert.assertTrue("Страница не загрузилась", valueCar.isDisplayed());
        setValue("250000");
        clickProceed();

        // Quote page

        WebElement checkout = driver.findElement(By.xpath("//button[text() = ' Checkout ']"));
        Assert.assertTrue("Страница не загрузилась", checkout.isDisplayed());
       // checkout.click();

    }

    @After
    public void after() {
        driver.quit();
    }

    public void setValue(String value){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String fieldXPath = "//input[@type='text']";
        WebElement element = driver.findElement(By.xpath(fieldXPath));
        element.click();
        element.sendKeys(value);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickProceed(){
        String buttonProceed = "//button[@type = 'submit' and text() = ' Proceed ']";
        WebElement element = driver.findElement(By.xpath(buttonProceed));
        element.click();
    }
}
