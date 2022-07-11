package com.sparta.jh;

import com.sparta.jh.pages.HNWebPage;
import org.openqa.selenium.WebDriver;

public class HNSubmitPage extends HNWebPage {
    private final WebDriver webDriver;

    public HNSubmitPage(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
    }
}
