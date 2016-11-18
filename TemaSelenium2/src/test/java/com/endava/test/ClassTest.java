package com.endava.test;

import com.endava.pages.Gmail1stAddress;
import com.endava.pages.Gmail2StAddress;
import com.endava.pages.Screenshot;
import com.gargoylesoftware.htmlunit.Page;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by mhahue on 11/15/2016.
 */
public class ClassTest {

    private WebDriver webDriver;
    private Screenshot screenshot;
    private Gmail1stAddress gmail1stAddress;
    private Gmail2StAddress gmail2StAddress;

    @Before
    public void before() {
        webDriver = new FirefoxDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void after() throws InterruptedException {
        Thread.sleep(2000);
        webDriver.close();
    }


    @Test
    public void classTest() {
        screenshot = PageFactory.initElements(webDriver, Screenshot.class);
        gmail1stAddress = screenshot.takeScreenshot();
        gmail2StAddress = gmail1stAddress.sendEmail1("seleniumtest557@gmail.com" , "pass1122", "seleniumtest579@gmail.com", "seleniumtest557@gmail.com", "Subject", "Message Body");


    }





}
