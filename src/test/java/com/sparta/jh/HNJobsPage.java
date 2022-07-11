package com.sparta.jh;

import com.sparta.jh.pages.HNWebPage;
import org.openqa.selenium.WebDriver;

public class HNJobsPage extends HNWebPage {
    private final WebDriver webDriver;

    public HNJobsPage(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
    }
}
