package com.emi.calculator.testcases;

import com.emi.calculator.screens.BaseScreen;
import com.emi.calculator.screens.Screen;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BaseTest {
    AndroidDriver driver;
    Screen screen;

    @BeforeClass
    public void launchApp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("udid", "192.168.56.101:5555");
        capabilities.setCapability("platformVersion", "12");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appPackage", "com.continuum.emi.calculator");
        capabilities.setCapability("appActivity", "com.finance.emicalci.activity.Splash_screnn");
        try {
            driver = new AndroidDriver(new URL("http://127.0.1.1:4723/wd/hub"), capabilities);
            screen = new BaseScreen(driver);
            driver.startRecordingScreen();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);

        }
    }

    @AfterClass
    public void closeApp() {
        recordingVideo();
        driver.quit();
    }

    public AndroidDriver getWebDriver() {
        return driver;
    }

    private void recordingVideo() {
        String base64String = driver.stopRecordingScreen();
        byte[] data = Base64.decodeBase64(base64String);
        String destinationPath = System.getProperty("user.dir") + "/build/videos/";
        File theDir = new File(destinationPath);
        if (!theDir.exists()) {
            theDir.mkdirs();
        }

        String filePath = destinationPath + "/" + driver.getDeviceTime().replace(":", "_").replace("+", " ") + ".mp4";
        System.out.println("filePath : " + filePath);
        Path path = Paths.get(filePath);
        try {
            Files.write(path, data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
