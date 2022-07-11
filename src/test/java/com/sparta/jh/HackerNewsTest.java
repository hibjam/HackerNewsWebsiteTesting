package com.sparta.jh;

import com.sparta.jh.pages.HNHomePage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;

public class HackerNewsTest {

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

    @BeforeAll
    static void setupALL() {
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
    }

    @BeforeEach
    void setup() {
        webDriver = new ChromeDriver(service);
        hnHomePage = new HNHomePage(webDriver);
    }

    @DisplayName("New Page Tests")
    @Nested
    class NewPageTests {
        @Test
        @DisplayName("New Page Test")
        void newPage() {
            hnNewPage = hnHomePage.goToNewPage();
            Assertions.assertEquals("https://news.ycombinator.com/newest", hnNewPage.getURL());
        }

        @Test
        @DisplayName("Page only has 30 headers")
        void thirtyArticles() {
            hnNewPage = hnHomePage.goToNewPage();
            Assertions.assertTrue(hnNewPage.only30HeadersOnPage());
        }

        @Test
        @DisplayName("Page 2 only has 30 headers")
        void thirtyArticlesOnPage2() {
            hnNewPage = hnHomePage.goToNewPage();
            Assertions.assertTrue(hnNewPage.only30HeadersOnNextPage());
        }

        @Test
        @DisplayName("Page href links are1 valid")
        void hrefLinkValid() {
            hnNewPage = hnHomePage.goToNewPage();
            Assertions.assertTrue(hnNewPage.allLinks());
        }

        @Test
        @DisplayName("More goes to 31")
        void moreHeadersTakesYouto31() {
            hnNewPage = hnHomePage.goToNewPage();
            Assertions.assertTrue(hnNewPage.moreLinkTakesYouTo31());
        }

        @AfterEach
        void tearDown() {
            webDriver.close(); // close the window
        }

        @AfterAll
        static void tearDownAll() {
            // driver.quit(); // kills the web driver
            service.stop();
        }
    }

    @Test
    void year() {
        hnPastPage = hnHomePage.goToPastPage();
        Assertions.assertTrue(hnPastPage.isLastYear());
    }

    @Test
    void badLogin() {
        hnLoginPage = hnHomePage.goToLoginPage();
        Assertions.assertTrue(hnLoginPage.badLoginRequest());
    }

    @Test
    void forgotPassword() {
        hnLoginPage = hnHomePage.goToLoginPage();
        Assertions.assertTrue(hnLoginPage.forgotPassword());
    }
    @Test
    void unknown(){
        hnLoginPage = hnHomePage.goToLoginPage();
        Assertions.assertTrue(hnLoginPage.unknownUser());
    }
}
