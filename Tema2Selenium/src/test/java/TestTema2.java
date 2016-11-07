import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.List;

/**
 * Created by mhahue on 11/6/2016.
 */
public class TestTema2 {


    private WebDriver driver;

    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "C:\\DRIVERS\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.cel.ro/");

        //Screenshot
        TakesScreenshot ts = (TakesScreenshot) driver;

        File screen = ts.getScreenshotAs(OutputType.FILE); //screenshot

        try {
            FileUtils.copyFile(screen, new File("screen.png")); //copiere screenshot la fisierul screen.png
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver.get("https://www.gmail.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @After
    public void after() {
        //driver.close();
    }

    @Test
    public void test() throws InterruptedException {


        //write username
        WebElement usernameField = driver.findElement(By.xpath("//input[@id='Email']"));
        usernameField.sendKeys("seleniumtest557@gmail.com");

        //press next button
        WebElement nextButton = driver.findElement(By.xpath("//input[@id='next']"));
        nextButton.click();

        //write password
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='Passwd']"));
        passwordField.sendKeys("pass1122");

        //press sign in button
        WebElement signInButton = driver.findElement(By.xpath("//input[@id='signIn']"));
        signInButton.click();

        //PRESS COMPOSE BUTTON
        WebElement composeButton = driver.findElement(By.xpath("//div[text() = 'COMPOSE']"));
        composeButton.click();

        //write2field
        WebElement write2Field = driver.findElement(By.xpath("//textarea[@aria-label='To']"));
        write2Field.sendKeys("seleniumtest579@gmail.com");

        Robot robot1 = null;

        try {
            robot1 = new Robot();
        } catch (AWTException e)
        {e.printStackTrace();
        }

        robot1.keyPress(KeyEvent.VK_ENTER);
        robot1.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(2000);

        //from
        WebElement fromField = driver.findElement(By.xpath("//span[contains(., 'seleniumtest557@gmail.com')]"));
        fromField.click();
        List<WebElement> emailList = driver.findElements(By.xpath("//div[contains(@value,'@gmail.com')]"));
        emailList.get(0).click();

        //subject
        WebElement subjectTest =  driver.findElement(By.xpath("//input[@name='subjectbox']"));
        subjectTest.sendKeys("Screenshot");

        //message body
        WebElement msgBody = driver.findElement(By.xpath("//div[@aria-label='Message Body']"));
        msgBody.sendKeys("I attach you the screenshot of the cel.ro site. May the force be with you.");

        //attach files
        WebElement attachFiles = driver.findElement(By.xpath("//div[@aria-label='Attach files']"));
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

        //send
        WebElement sendButton = driver.findElement(By.xpath("//div[contains(@aria-label,'Send')]"));
        sendButton.click();
        Thread.sleep(9000);


        //delogare mail curent
        WebElement userSignOut = driver.findElement(By.xpath("//span[@class='gb_8a gbii']"));
        userSignOut.click();

        //sign out
        WebElement signOut = driver.findElement(By.xpath("//a[text() = 'Sign out'] "));
        signOut.click();

        //connect with another account
        WebElement anotherAccount = driver.findElement(By.xpath("//a[@id='account-chooser-link']"));
        anotherAccount.click();

        //add another account
        WebElement addAccount = driver.findElement(By.xpath("//a[text() = 'Add account']"));
        addAccount.click();


        //add seleniumtest579@gmail.com
        WebElement usernameField1 = driver.findElement(By.xpath("//input[@id='Email']"));
        usernameField1.sendKeys("seleniumtest579@gmail.com");

        //press next button
        WebElement nextButton1 = driver.findElement(By.xpath("//input[@id='next']"));
        nextButton1.click();

        //write password for seleniumtest579
        WebElement passwordField1 = driver.findElement(By.xpath("//input[@id='Passwd']"));
        passwordField1.sendKeys("test1122");

        //press sign in button
        WebElement signInButton1 = driver.findElement(By.xpath("//input[@id='signIn']"));
        signInButton1.click();

        //select mail from selenium557
        List<WebElement> email = driver.findElements(By.cssSelector("div.xT>div.y6>span>b"));

        for(WebElement emailsub : email){
            if(emailsub.getText().equals("Screenshot") == true){

                emailsub.click();
                break;
            }
        }

        //download image
        WebElement downloadImage = driver.findElement(By.xpath("//div[@data-tooltip='Download']"));
        downloadImage.click();
    }


}
