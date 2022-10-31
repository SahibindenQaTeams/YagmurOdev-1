package com;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class test {
    @Test
    public static void main(String[] args) throws InterruptedException {
    System.setProperty("webdriver.chrome.driver","C:\\Users\\yagmur.kilic\\Desktop\\chromedriver.exe");
    ChromeDriver driver = new ChromeDriver();
    driver.get("https://www.sahibinden.com/kayit");
    driver.manage().window().maximize();
    driver.findElement(By.id("name")).sendKeys("Yağmur");
    driver.findElement(By.id("surname")).sendKeys("Kılıç");
    driver.findElement(By.id("email")).sendKeys("abc"+(Math.random()*100)+"@gmail.com");
    driver.findElement(By.id("password")).sendKeys("123456aB");
    WebDriverWait wait = new WebDriverWait(driver,15);
    driver.executeScript("document.getElementById('endUserLicenceAgreement').click()");
    driver.findElement(By.id("signUpButton")).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("confirmSubmit")));
    driver.findElement(By.id("confirmSubmit")).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#container .email-activation .email")));
    String EmailIsCorrect = driver.findElement(By.cssSelector("#container .email-activation .email")).getText();
    System.out.println(EmailIsCorrect);
    Thread.sleep(4000);
    driver.quit();
    }
}
