package com.sparta.jh;

import com.sparta.jh.pages.HNWebPage;
import org.openqa.selenium.WebDriver;

public class HNShowPage extends HNWebPage {

    private final WebDriver webDriver;

    public HNShowPage(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
    }
}
