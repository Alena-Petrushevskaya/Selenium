
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class firstTest {
    @Test
    public void checkMobPayment() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver =  new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://next.privat24.ua/mobile");

        By phoneNumber = By.xpath("//input[@data-qa-node='phone-number']");
        driver.findElement(phoneNumber).sendKeys("667239794");
        By amount = By.xpath("//input[@data-qa-node='amount']");
        driver.findElement(amount).sendKeys("1");
        By cardNumber = By.xpath("//input[@data-qa-node='numberdebitSource']");
        driver.findElement(cardNumber).sendKeys("4567739561253907");
        By expDate = By.xpath("//input[@data-qa-node='expiredebitSource']");
        driver.findElement(expDate).sendKeys("02/23");
        By cvv = By.xpath("//input[@data-qa-node='cvvdebitSource']");
        driver.findElement(cvv).sendKeys("222");

        Thread.sleep(2);
        By name = By.xpath("//input[@data-qa-node='firstNamedebitSource']");
        driver.findElement(name).sendKeys("Test");
        By surname = By.xpath("//input[@data-qa-node='lastNamedebitSource']");
        driver.findElement(surname).sendKeys("Testovich");
        By button = By.xpath("//button[@data-qa-node='submit']");
        driver.findElement(button).click();

       By cardNumberFrom = By.xpath("//td[@data-qa-node='card']");
       Assert.assertEquals("4567 **** **** 3907",driver.findElement(cardNumberFrom).getText());
       By payAmount = By.xpath("//div[@data-qa-node='amount']");
       System.out.println(driver.findElement(payAmount).getText());
       By commission = By.xpath("//span[@data-qa-node='commission']");
       System.out.println(driver.findElement(commission).getText());
       By details = By.xpath("//div[@data-qa-node='details']");
       Assert.assertEquals("Поповнення телефону. На номер +380667239794",driver.findElement(details).getText());
       By recipient = By.xpath("//span[@data-qa-node='nameB']");
       System.out.println(driver.findElement(recipient).getText());

    }

}
