package com.endava.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by mhahue on 11/7/2016.
 */
public class HomePage {

    private WebDriver driver;

    // Navigate to “www.shopmania.ro”
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.driver.get("http://www.shopmania.ro/");
    }

    @FindBy(xpath = "//input[@id='autocomplete_prod']")
    private WebElement searchField;

    @FindBy(xpath = "//form[@id='main_search']/div/span[2]")
    private WebElement searchButton;

    //Search for “Samsung S7”
    public MobilePage searchTelephone(String nameOfTelephone) {
        searchField.sendKeys(nameOfTelephone);
        searchButton.click();

        //return the next page
        MobilePage mobilePage = PageFactory.initElements(driver, MobilePage.class);
        mobilePage.waitForPageToLoad();
        return mobilePage;
    }


}
