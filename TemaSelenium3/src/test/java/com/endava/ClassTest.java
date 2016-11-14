package com.endava;

import com.endava.pages.HomePage;
import com.endava.pages.MobilePage;
import com.endava.pages.SamsungMobilePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

/**
 * Created by mhahue on 11/7/2016.
 */
public class ClassTest {

    private WebDriver driver;
    private HomePage homePage;
    private MobilePage mobilePage;
    private SamsungMobilePage samsungMobilePage;

    @Before
    public void before() {

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @After
    public void after() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();

    }

    @Test
    public void testReferrals() {
        mobilePage = homePage.searchTelephone("Samsung S7");
        samsungMobilePage = mobilePage.clickCategory("Telefoane mobile");
        samsungMobilePage.listTotalProducts("Samsung Galaxy S7 Edge");
        String totalAvailableShops = samsungMobilePage.getAvailableShops();
        assertTrue("85".equals(totalAvailableShops));

        samsungMobilePage.assertPage();
    }


    }



