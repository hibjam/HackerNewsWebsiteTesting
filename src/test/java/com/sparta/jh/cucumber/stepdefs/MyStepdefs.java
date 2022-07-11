package com.sparta.jh.cucumber.stepdefs;

import com.sparta.jh.*;
import com.sparta.jh.pages.HNHomePage;
import com.sparta.jh.pages.InvalidWebPageException;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
// can have multiple stepdefs but cucumber will treat it as one big file

public class MyStepdefs {
    private WebDriver webDriver;
    private static ChromeDriverService service;
    private static ChromeOptions options;

    private HNHomePage hnHomePage;
    private HNNewPage hnNewPage;
    private HNPastPage hnPastPage;
    private HNCommentsPage hnCommentsPage;
    private HNAskPage hnAskPage;
    private HNShowPage hnShowPage;
    private HNJobsPage hnJobsPage;
    private HNSubmitPage hnSubmitPage;
    private HNLoginPage hnLoginPage;



    @Before // must be public
    // Cucumbers before and BeforeStep are the same as Junits before each and before all
    // BeforeStep runs before each statement in EVERY file - because it treats all files as one big file so you only write hooks in one file
    public void setup(){
        service = new ChromeDriverService
                .Builder()
                .usingDriverExecutable(new File("src/test/resources/chromedriver.exe"))
                .usingAnyFreePort()
                .build();


        try {
            service.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

        options = new ChromeOptions();
        options.addArguments("headless");
        webDriver = new ChromeDriver(service, options);
    }

    @Given("I am on the homepage")
    public void iAmOnTheHomepage() {
        hnHomePage = new HNHomePage(webDriver);
    }

    @When("I click on the comments link")
    public void iClickOnTheCommentsLink() {
        hnCommentsPage = hnHomePage.goToCommentsPage();
    }

    @Then("I will go to the comments page")
    public void iWillGoToTheCommentsPage() {
        Assertions.assertEquals("https://news.ycombinator.com/newcomments", hnCommentsPage.getURL());
    }

    @When("I click on the new link")
    public void iClickOnTheNewLink() {
        hnNewPage = hnHomePage.goToNewPage();
    }

    @Then("I will go to the new page")
    public void iWillGoToTheNewPage() {
        Assertions.assertEquals("https://news.ycombinator.com/newest", hnNewPage.getURL());
    }

    @When("I click on the past link")
    public void iClickOnThePastLink() {
        hnPastPage = hnHomePage.goToPastPage();

    }

    @Then("I will go to the past page")
    public void iWillGoToThePastPage() {
        Assertions.assertEquals("https://news.ycombinator.com/front", hnPastPage.getURL());
    }

    @When("I click on the ask link")
    public void iClickOnTheAskLink() {
        hnAskPage = hnHomePage.goToAskPage();
    }

    @Then("I will go to the ask page")
    public void iWillGoToTheAskPage() {
        Assertions.assertEquals("https://news.ycombinator.com/ask", hnAskPage.getURL());
    }

    @When("I click on the show link")
    public void iClickOnTheShowLink() {
        hnShowPage = hnHomePage.goToShowPage();
    }

    @Then("I will go to the show page")
    public void iWillGoToTheShowPage() {
        Assertions.assertEquals("https://news.ycombinator.com/show", hnShowPage.getURL());
    }

    @When("I click on the jobs link")
    public void iClickOnTheJobsLink() {
        hnJobsPage = hnHomePage.goToJobsPage();
    }

    @Then("I will go to the jobs page")
    public void iWillGoToTheJobsPage() {
        Assertions.assertEquals("https://news.ycombinator.com/jobs", hnJobsPage.getURL());
    }

    @When("I click on the submit link")
    public void iClickOnTheSubmitLink() {
        hnSubmitPage = hnHomePage.goToSubmitPage();
    }

    @Then("I will go to the submit page")
    public void iWillGoToTheSubmitPage() {
        Assertions.assertEquals("https://news.ycombinator.com/submit", hnSubmitPage.getURL());
    }

    @When("I click on the login link")
    public void iClickOnTheLoginLink() {
        hnLoginPage = hnHomePage.goToLoginPage();

    }

    @Then("I will go to the login page")
    public void iWillGoToTheLoginPage() {
        Assertions.assertEquals("https://news.ycombinator.com/login?goto=news", hnLoginPage.getURL());
    }


    @Given("I am on the HN Website")
    public void iAmOnTheHNWebsite() {
        hnHomePage = new HNHomePage(webDriver);
    }

    @When("I navigate to a page containing different items")
    public void iNavigateToAPageContainingDifferentItems() {
        hnNewPage = hnHomePage.goToNewPage();
    }

    @Then("I should be able to see 30 items per page")
    public void iShouldBeAbleToSeeItemsPerPage() {
        Assertions.assertTrue(hnNewPage.only30HeadersOnPage());
    }


}
