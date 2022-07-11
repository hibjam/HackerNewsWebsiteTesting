package com.sparta.jh.pages;

import com.sparta.jh.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class HNHomePage {

    private final WebDriver webDriver;

    private By newLink = new By.ByLinkText("new");
    private By pastLink = new By.ByLinkText("past");
    private By commentsLink = new By.ByLinkText("comments");
    private By askLink = new By.ByLinkText("ask");
    private By showLink = new By.ByLinkText("show");
    private By jobsLink = new By.ByLinkText("jobs");
    private By submitLink = new By.ByLinkText("submit");
    private By loginLink = new By.ByLinkText("login");

    public HNHomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.get("https://news.ycombinator.com/");
    }

    public HNHomePage goToHomePage() {
        webDriver.get("https://news.ycombinator.com/");
        return this;
    }

    public HNNewPage goToNewPage(){
        webDriver.findElement(newLink).click();
        return new HNNewPage(webDriver);
    }


    public HNPastPage goToPastPage() {
        webDriver.findElement(pastLink).click();
        return new HNPastPage(webDriver);
    }

    public HNCommentsPage goToCommentsPage(){
        webDriver.findElement(commentsLink).click();
        return new HNCommentsPage(webDriver);
    }

    public HNAskPage goToAskPage(){
        webDriver.findElement(askLink).click();
        return new HNAskPage(webDriver);
    }

    public HNShowPage goToShowPage(){
        webDriver.findElement(showLink).click();
        return new HNShowPage(webDriver);
    }

    public HNJobsPage goToJobsPage(){
        webDriver.findElement(jobsLink).click();
        return new HNJobsPage(webDriver);
    }

    public HNSubmitPage goToSubmitPage(){
        webDriver.findElement(submitLink).click();
        return new HNSubmitPage(webDriver);
    }

    public HNLoginPage goToLoginPage(){
        webDriver.findElement(loginLink).click();
        return new HNLoginPage(webDriver);
    }





}