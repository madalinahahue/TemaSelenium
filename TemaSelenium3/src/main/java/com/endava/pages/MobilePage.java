package com.endava.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by mhahue on 11/10/2016.
 */
public class MobilePage {

    private WebDriver driver;

    public MobilePage(WebDriver driver)
    {
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@id='main_col']/div/ul[1]/li/a")
    private List<WebElement> categoryField;

    public SamsungMobilePage clickCategory(String mobileTitle) {

        for (WebElement title : categoryField) {
            if (title.getText().equals(mobileTitle)) {
                title.click();

                SamsungMobilePage samsungMobilePage = PageFactory.initElements(driver, SamsungMobilePage.class);
                return samsungMobilePage;
            }

        }
        return null;
    }


    public void waitForPageToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, 20);

    }


}
