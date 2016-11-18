package com.endava.pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

/**
 * Created by mhahue on 11/15/2016.
 */
public class Screenshot {
    private WebDriver webDriver;

    public Screenshot(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriver.get("http://www.cel.ro/");
        //System.setProperty("webdriver.chrome.driver", "C:\\DRIVERS\\chromedriver.exe");
        webDriver.manage().window().maximize();
    }

    public Gmail1stAddress takeScreenshot() {
        TakesScreenshot sc = (TakesScreenshot) webDriver;
        File screen = sc.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screen, new File("screen.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Gmail1stAddress gmail1 = PageFactory.initElements(webDriver, Gmail1stAddress.class);
        gmail1.waitForPageToLoad();
        return gmail1;
    }






}
