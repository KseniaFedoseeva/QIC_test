package com.test.qic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CarTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void befor() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10, 1000);

    }

    @Test
    public void test() {

        driver.navigate().to("https://lp.qic-insured.com/en");
        WebDriverWait wait = new WebDriverWait(driver, 30, 2000);

        //Переход в car

        WebElement itemCar = driver.findElement(By.xpath("//div[@class = 'offerMain__insurance-item car']"));
        itemCar.click();

        //Выбор бренда

        WebElement itemBrand = driver.findElement(By.xpath("//p[text() = 'Toyota']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"landForm\"]/div/div[1]/div[1]"))); // проверка
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

        setValue("23333333333");
        clickProceed();

        WebElement firstName = driver.findElement(By.xpath("//label[text()='First Name']"));
        firstName.click();
        firstName.sendKeys("Anna");

        WebElement familyName = driver.findElement(By.xpath("//label[text()='Family Name']"));
        familyName.click();
        familyName.sendKeys("Smith");
        clickProceed();


        WebElement titlePage = driver.findElement(By.xpath("//h1[@class='boxForm_heading']"));
        Assert.assertTrue("Страница не загрузилась", titlePage.isDisplayed() && titlePage.getText().contains("Date of Birth"));
        clickProceed();


    }
    public void setValue(String value){
        String fieldXPath = "//input[@type='text']";
        WebElement element = driver.findElement(By.xpath(fieldXPath));
        element.click();
        element.sendKeys(value);
    }

    public void clickProceed(){
        String buttonProceed = "//button[@type = 'submit' and text() = ' Proceed ']";
        WebElement element = driver.findElement(By.xpath(buttonProceed));
        element.click();
    }
}
