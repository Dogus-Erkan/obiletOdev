package com.obilet.utils;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestConfiguration {
    public static AppiumDriver<MobileElement> driver;

    @BeforeScenario
    public void beforeTest() {
        try {
            System.out.println("Driver Ayağa Kalkıyor...");
            DesiredCapabilities dCap = new DesiredCapabilities();

            dCap.setCapability("deviceName", "Pixel 7 API 33");
            dCap.setCapability("platformName", "Android");
            dCap.setCapability("udid", "emulator-5554");
            dCap.setCapability("platformVersion", "13.0");
            dCap.setCapability("appPackage", "com.obilet.androidside");
            dCap.setCapability("appActivity", "com.obilet.androidside.presentation.screen.splash.activity.SplashScreen");


            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), dCap);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        } catch (Exception e) {
            System.out.println("URL Hatalı oluşturulmuş!");
        }
    }

    @AfterScenario
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Driver Kapatıldı.");
        }
    }


}
