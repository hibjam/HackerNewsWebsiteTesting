package com.sparta.jh;

import com.sparta.jh.pages.HNWebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class HNLoginPage extends HNWebPage  {
    private final WebDriver webDriver;

    public HNLoginPage(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
    }
    public boolean badLoginRequest(){
        webDriver.findElement(By.name("acct")).sendKeys("This Should 100% be invalid");
        webDriver.findElement(By.name("pw")).sendKeys("lalalala");
        webDriver.findElement(By.cssSelector("body > form:nth-child(4) > input[type=submit]:nth-child(4)")).click();
        String badLogin = webDriver.findElement(By.cssSelector("body")).getText();
       return badLogin.startsWith("Bad login.");
    }

    public boolean forgotPassword(){
        webDriver.findElement(By.cssSelector("body > a")).click();
        return webDriver.getCurrentUrl().equals("https://news.ycombinator.com/forgot");
    }

    public boolean unknownUser(){
//        WebElement firstResult = new WebDriverWait(webDriver, Duration.ofSeconds(10))
//                .until(ExpectedConditions.elementToBeClickable(By.linkText("Forgot your password?")));

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        webDriver.findElement(By.linkText("Forgot your password?")).click();
        webDriver.findElement(By.cssSelector("body > form > input[type=text]:nth-child(3)"))
                .sendKeys("thisisnotgoingtobeavalidemailandifitisIhopetheyrehavinganiceday@gmail.com");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

       webDriver.findElement(By.cssSelector("body > form > input[type=submit]:nth-child(6)")).click();

        String unknownUser = webDriver.findElement(By.cssSelector("body")).getText();
        System.out.println(unknownUser);
        return unknownUser.contains("Unknown user");
    }
}
