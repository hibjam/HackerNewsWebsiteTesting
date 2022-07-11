package com.sparta.jh;

import com.sparta.jh.pages.HNWebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;

public class HNPastPage extends HNWebPage {
    private final WebDriver webDriver;

    public HNPastPage(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
    }

    public boolean isYesterday(){
        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(1);
        String dateCheck = webDriver.findElement(By.className("pagetop")).getText();
        return dateCheck.contains(yesterday.toString());
    }
    public boolean isLastYear(){
        LocalDate today = LocalDate.now();
        LocalDate lastYear = today.minusYears(1).minusDays(1);
        webDriver.findElement(By.linkText("year")).click();
        String dateCheck = webDriver.findElement(By.className("pagetop")).getText();
        return dateCheck.contains(lastYear.toString());
    }
}
