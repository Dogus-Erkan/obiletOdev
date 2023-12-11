package com.obilet.steps;

import com.obilet.methods.Method;
import com.thoughtworks.gauge.Step;


public class StepImplementation extends Method {

    @Step("<type> tipindeki elementin ekranda bulunduğu kontrol edilir <elementLocator>")
    public void isElementExistSt(String type, String elementLocator) {
     isElementExist(type,elementLocator);
    }

    @Step("<type> tipindeki elemente tıklanır <elementLocator>")
    public void clickElementST(String type, String elementLocator) {
       clickElement(type,elementLocator);
    }

    @Step("<type> tipindeki elementin geçiş yapılan sayfada olduğunu kontrol edilir <elementLocator>")
    public void findElementOnNewPageSt(String type, String elementLocator) {
       findElementOnNewPage(type,elementLocator);
    }

    @Step("<type> tipindeki elemente <text> değeri yazılır <elementLocator>")
    public void sendKeysToElementSt(String type, String text, String elementLocator) {
        sendKeysToElement(type,text,elementLocator);
    }

    @Step("<type> tipindeki elemente tıklanır ve <text> değeri yazılır <elementLocator>")
    public void sendKeysToElementAndClickSt(String type, String elementLocator, String text) {
       sendKeysToElementAndClick(type,elementLocator,text);
    }

    @Step("Rastgele bir gidiş tarihi seçilir")
    public void selectRandomDateSt() {
        selectRandomDate();
    }

    @Step("Rastgele bir sefer seçilir")
    public void selectRandomTripSt() {
       selectRandomTrip();
    }

    @Step("Koltuk sayısı <number> değeri kadar seçilir")
    public void selectPassengerSt(int number) {
       selectPassenger(number);
    }

    @Step("<second> saniye beklenir")
    public void waitForSt(int second) {
       waitFor(second);
    }

    @Step("<type> tipindeki Element Görünene Kadar Beklenir <elementLocator>")
    public void waitForElementVisibilitySt(String type, String elementLocator) {
       waitForElementVisibility(type,elementLocator);
    }
}
