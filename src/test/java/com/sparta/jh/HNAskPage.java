package com.sparta.jh;

import com.sparta.jh.pages.HNWebPage;
import org.openqa.selenium.WebDriver;

public class HNAskPage extends HNWebPage {
    private final WebDriver webDriver;

    public HNAskPage(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
    }



}

