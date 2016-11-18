package com.endava.pages;

import com.gargoylesoftware.htmlunit.Page;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by mhahue on 11/15/2016.
 */
public class Gmail1stAddress {

    public WebDriver webDriver;

    public Gmail1stAddress(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.get("https://www.gmail.com");
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    //write username
    @FindBy(id = "Email")
    private WebElement enterUsername;

    //press next button
    @FindBy(id = "next")
    private WebElement pressNextButton;

    //write password
    @FindBy(id = "Passwd")
    private WebElement enterPassword;

    //press sign in button
    @FindBy(id = "signIn")
    private WebElement singInButton;

    //press compose button
    @FindBy(xpath = "//div[text() = 'COMPOSE']")
    private WebElement composeButton;

    //write2field
    @FindBy(xpath = "//textarea[@aria-label='To']")
    private WebElement write2Field;

    //from
    @FindBy(xpath = "//span[contains(., 'seleniumtest557@gmail.com")
    private WebElement fromField;

    //list email
    @FindBy(xpath = "//div[contains(@value,'@gmail.com')]")
    private List<WebElement> emailList;

    //subject
    @FindBy(xpath = "//input[@name='subjectbox']")
    private WebElement writeSubject;

    //message body
    @FindBy(xpath = "//div[@aria-label='Message Body']")
    private WebElement writeMessageBody;

    //attach files
    @FindBy(xpath = "//div[@aria-label='Attach files']")
    private WebElement attachFiles;

    //sendMail
    @FindBy(xpath = "//div[contains(@aria-label,'Send')]")
    private WebElement sendMail;



    public Gmail2StAddress sendEmail1(String username,String password, String destinatar, String from, String subject,
                                      String messageBody){
        enterUsername.sendKeys(username);
        pressNextButton.click();
        enterPassword.sendKeys(password);
        singInButton.click();
        composeButton.click();
        write2Field.sendKeys(destinatar);

        //select email
        Robot robot1 = null;
        try
            {
            robot1 = new Robot();
            } catch(AWTException e) {
            e.printStackTrace();
            }

        robot1.keyPress(KeyEvent.VK_ENTER);
        robot1.keyRelease(KeyEvent.VK_ENTER);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }




        fromField.sendKeys(from);
        emailList.get(0).click();
        writeSubject.sendKeys(subject);
        writeMessageBody.sendKeys(messageBody);
        attachFiles.click();

        //attach screenshot
        //path
        StringSelection ss = new StringSelection("C:\\Users\\mhahue\\IdeaProjects\\Tema2Selenium\\screen.png");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

        Robot robot2 = null;

        try {
            robot2 = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }


        robot2.keyPress(KeyEvent.VK_ENTER);
        robot2.keyRelease(KeyEvent.VK_ENTER);

        try {
            Thread.sleep(5000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        robot2.keyPress(KeyEvent.VK_CONTROL);
        robot2.keyPress(KeyEvent.VK_V);
        robot2.keyRelease(KeyEvent.VK_V);
        robot2.keyPress(KeyEvent.VK_CONTROL);


        try {
            Thread.sleep(5000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        robot2.keyPress(KeyEvent.VK_ENTER);
        robot2.keyRelease(KeyEvent.VK_ENTER);

        sendMail.click();
        try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        Gmail2StAddress gmail2StAddress = PageFactory.initElements(webDriver, Gmail2StAddress.class);
        return gmail2StAddress;

    }


    public void waitForPageToLoad() {
        WebDriverWait wait = new WebDriverWait(webDriver, 20);
        //wait.until(ExpectedConditions.visibilityOfAllElements())
    }
}
