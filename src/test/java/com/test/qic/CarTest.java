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
        Assert.assertTrue("Страница не загрузилась", select.isDisplayed());
        Assert.assertTrue("Страница не загрузилась", selectTitle.isDisplayed());
        select.click();

        //Указываем стоимость авто Подзаголовок //p[text() = 'The average market price, including depreciation']

      //  WebElement valueCar = driver.findElement(By.xpath("p[text() = 'The average market price, including depreciation']"));
      //  Assert.assertTrue("Страница не загрузилась", valueCar.isDisplayed());
        WebElement priceCar = driver.findElement(By.xpath("//input[@type='text']"));
        action.moveToElement(priceCar);
        action.click(priceCar);
        action.sendKeys(priceCar, "250000").perform();

        clickProceed();

        // Quote page
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement checkout = driver.findElement(By.xpath("//button[text() = ' Checkout ']"));
        Assert.assertTrue("Страница не загрузилась", checkout.isDisplayed());
        WebElement creditCard = driver.findElement(By.xpath("//label[text()='Credit Card']"));
        creditCard.click();
        checkout.click();

        // Заполнение форм оплаты

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement clickNext = driver.findElement(By.xpath("//input[@type='submit']"));
        clickNext.click();
        WebElement cardVisa = driver.findElement(By.xpath("//label[@for='card_type_001']"));
        cardVisa.click();

        // Card number

        WebElement cardNumber = driver.findElement(By.xpath("//input[@name='card_number']"));
        action.moveToElement(cardNumber);
        action.click(cardNumber);
        action.sendKeys(cardNumber, "4111111111111111").perform();

        WebElement exMonth = driver.findElement(By.xpath("//select[@name='card_expiry_month']"));
        exMonth.click();
        WebElement numMonth = driver.findElement(By.xpath("//option[@value='01']"));
        numMonth.click();
        WebElement exYear = driver.findElement(By.xpath("//select[@name='card_expiry_year']"));
        exYear.click();
        WebElement numYear = driver.findElement(By.xpath("//option[@value='2029']"));
        numYear.click();

        //CVC

        WebElement carCVC = driver.findElement(By.xpath("//input[@name = 'card_cvn']"));
        action.moveToElement(carCVC);
        action.click(carCVC);
        action.sendKeys(carCVC, "000").perform();

        //Review your Order

        WebElement reviewOrder = driver.findElement(By.xpath("//h2[text() = 'Review your Order']"));
        Assert.assertTrue("Страница не загрузилась", reviewOrder.isDisplayed());
        clickNext.click();

        // Download policy page

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement downloadPolicy = driver.findElement(By.xpath("//a[@class = 'btn btnInsSuc']"));
        Assert.assertTrue("Страница не загрузилась", downloadPolicy.isDisplayed());


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
