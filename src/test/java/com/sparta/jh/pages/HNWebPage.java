package com.sparta.jh.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class HNWebPage {
    private String pattern = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
    private WebDriver webDriver;

    public HNWebPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean allLinks() {
        List<WebElement> headers = webDriver.findElements(By.className("titlelink"));
        List<String> links = new ArrayList<>();
        for (WebElement header : headers) {
            links.add(header.getAttribute("href"));
        }
        try {
            for (String link : links) {
                Pattern pat = Pattern.compile(pattern);
                Matcher match = pat.matcher(link);
                return match.matches();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public String getURL() {
        return webDriver.getCurrentUrl();
    }

    public boolean only30HeadersOnPage() {
        int headerCount = webDriver.findElements(By.className("athing")).size();
        return headerCount == 30;
    }

    public boolean only30HeadersOnNextPage() {
        webDriver.findElement(By.className("morelink")).click();
        int headerCount = webDriver.findElements(By.className("athing")).size();
        return headerCount == 30;
    }

    public boolean moreLinkTakesYouTo31() {
        webDriver.findElement(By.className("morelink")).click();
        String text = webDriver.findElement(By.className("title")).getText();
        return text.equals("31.");
    }
}


