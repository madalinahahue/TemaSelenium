package com.endava.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by mhahue on 11/10/2016.
 */
public class SamsungMobilePage {
    private WebDriver driver;

    public SamsungMobilePage(WebDriver driver) {
        this.driver = driver;
    }


    @FindBy(xpath = "//div[@id='main_products_container']/ul/li")
    private List<WebElement> listProducts;

    @FindBy(xpath = "//div[@id='main_products_container']/ul/li//p[@class='text-xl']/a")
    private List<WebElement> listOfTitles;

    @FindBy(xpath = "//div[@id='main_products_container']/ul/li//a[@class='price-offer']")
    private List<WebElement> listOfPrices;


    public void listTotalProducts(String nameProduct) {
        for(int i = 0 ; i<listProducts.size(); i++ ) {

            String name = listOfTitles.get(i).getText();
            String price = listOfPrices.get(i).getText();
            if(name.contains(nameProduct))
            {
                System.out.println(name + " , " + price);
            }

        }
    }
    //Count and print the number of available shops.
    @FindBy(xpath = "//div[@id='page_content']/div[1]/div/div[1]/ul/li[5]/span")
    private WebElement availableShops;

    public String getAvailableShops() {
        String totalAvailableShops = availableShops.getText();
        System.out.println("The number of available shops is: " + totalAvailableShops + "\n");
        return totalAvailableShops;
    }

    //click on price ASC
    @FindBy(xpath = "//div[@id='page_content']/div[4]/div/ul[1]/li[2]/a")
    private WebElement sortAsc;


    //Print the shop name and price where this phone has the minimum price
    @FindBy(xpath ="//a[@class=\'price-offer\']")
    private List<WebElement> selectPrice;

    @FindBy(xpath = "//div[@class='div-offer']//div[1]/a")
    private List<WebElement> selectShop;


    //Verify the maximum price for this phone and print the shop name and price

    public void assertPage() {
        sortAsc.click();

        String lowestPrice = selectPrice.get(0).getText();
        System.out.println("Minimum price is " + lowestPrice);

        String minShop = selectShop.get(0).getAttribute("title");
        System.out.println("For the " + minShop + " shop(min)"+"\n");


        sortAsc.click();
        String highestPrice = selectPrice.get(0).getText();
        System.out.println("Maximum price is " + highestPrice );

        String maxShop = selectShop.get(0).getAttribute("title");
        System.out.println("For the " + maxShop + " shop(max)");
    }


    public void waitForPageToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
    }
}
