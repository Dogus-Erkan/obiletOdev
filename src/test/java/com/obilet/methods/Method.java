package com.obilet.methods;

import com.obilet.utils.TestConfiguration;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

public class Method extends TestConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(com.obilet.steps.StepImplementation.class);

    private MobileElement findElementByType(String type, String elementLocator) {
        MobileElement element = null;
        try {
            switch (type) {
                case "id":
                case "ID":
                case "Id":
                    element = driver.findElement(By.id(elementLocator));
                    return element;
                case "xpath":
                case "XPATH":
                case "Xpath":
                    element = driver.findElement(By.xpath(elementLocator));
                    return element;
            }
        } catch (NoSuchElementException e) {
            logger.error("Element ekranda bulunamadı:" + e.getMessage());
            Assert.fail("Element ekranda bulunamadı: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("Hatalı tip: " + e.getMessage());
            Assert.fail("Hatalı tip: " + e.getMessage());
        } catch (Exception e) {
            logger.error("Beklenmeyen bir hata oluştu:" + e.getMessage());
            Assert.fail("Beklenmeyen bir hata oluştu: " + e.getMessage());
        }
        return element;
    }

    public void isElementExist(String type, String elementLocator) {
        try {
            MobileElement element = findElementByType(type, elementLocator);
            Assert.assertNotNull(element, "Belirtilen element bulunamadı.");
        } catch (Exception e) {
            logger.error("Element Ekranda Bulunamadı: " + e.getMessage());
            Assert.fail("Element Ekranda Bulunamadı: " + e.getMessage());
        }
    }


    public void clickElement(String type, String elementLocator) {
        MobileElement element = findElementByType(type, elementLocator);
        try {
            element.click();
        } catch (Exception e) {
            logger.error("Element Ekranda Bulunamadı: " + e.getMessage());
            Assert.fail("Elemente tıklanamadı!" + e.getMessage());
        }
    }


    public void findElementOnNewPage(String type, String elementLocator) {
        try {
            MobileElement element = findElementByType(type, elementLocator);
            Assert.assertNotNull(element, "Belirtilen element bulunamadı.");
        } catch (Exception e) {
            logger.error("Element Geçilen Sayfada Bulunamadı! " + e.getMessage());
            Assert.fail("Element Geçilen Sayfada Bulunamadı! " + e.getMessage());
        }
    }


    public void sendKeysToElement(String type, String text, String elementLocator) {
        try {
            MobileElement element = findElementByType(type, elementLocator);
            element.sendKeys(text);
        } catch (Exception e) {
            logger.error("Elemente Text Değeri Gönderilemedi! " + e.getMessage());
            Assert.fail("Elemente Text Değeri Gönderilemedi! " + e.getMessage());
        }
    }


    public void sendKeysToElementAndClick(String type, String elementLocator, String text) {
        try {
            MobileElement element = findElementByType(type, elementLocator);
            element.click();
            element.sendKeys(text);
        } catch (Exception e) {
            logger.error("Elemente Text Değeri Gönderilemedi! " + e.getMessage());
            Assert.fail("Elemente Text Değeri Gönderilemedi!" + e.getMessage());
        }
    }


    public void selectRandomDate() {
        try {
            Random rnd = new Random();
            List<MobileElement> elements = driver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.obilet.androidside:id/tv_day_number']"));
            int lastElementIndex = elements.size();
            LocalDate today = LocalDate.now();
            int currentDay = today.getDayOfMonth();
            int randomNumber = currentDay + rnd.nextInt(lastElementIndex - currentDay + 1);
            MobileElement element = driver.findElement(By.xpath("(//android.widget.TextView[@resource-id='com.obilet.androidside:id/tv_day_number'])[" + randomNumber + "]"));
            element.click();
        } catch (Exception e) {
            logger.error("Elemente tıklanamadı! " + e.getMessage());
            Assert.fail("Elemente tıklanamadı!" + e.getMessage());
        }
    }


    public void selectRandomTrip() {
        try {
            Random rnd = new Random();
            List<MobileElement> elements = driver.findElements(By.xpath("(//android.view.ViewGroup[@resource-id='com.obilet.androidside:id/item_bus_journey_list_rootLayout'])"));
            int lastElementIndex = elements.size();
            int randomNumber = rnd.nextInt(lastElementIndex) + 1;
            MobileElement element = driver.findElement(By.xpath("(//android.view.ViewGroup[@resource-id='com.obilet.androidside:id/item_bus_journey_list_rootLayout'])[" + randomNumber + "]"));
            element.click();
        } catch (Exception e) {
            logger.error("Elemente tıklanamadı! " + e.getMessage());
            Assert.fail("Elemente tıklanamadı!" + e.getMessage());
        }
    }


    public void selectPassenger(int number) {
        try {
            for (int i = 1; i < number; i++) {
                MobileElement element = driver.findElement(By.xpath("(//android.widget.ImageButton[@resource-id='com.obilet.androidside:id/branded_fare_increase_ticket_button'])[1]"));
                element.click();
            }
        } catch (Exception e) {
            logger.error("Elemente tıklanamadı! " + e.getMessage());
            Assert.fail("Elemente tıklanamadı!" + e.getMessage());
        }
    }


    public void waitFor(int second) {
        try {
            Thread.sleep(second * 1000L);
        } catch (InterruptedException e) {
            logger.error("Hata Alındı! " + e.getMessage());
            Assert.fail("Hata Alındı! " + e.getMessage());
        }
    }


    public void waitForElementVisibility(String type, String elementLocator) {
        MobileElement element = findElementByType(type, elementLocator);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
