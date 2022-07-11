package com.sparta.jh;

import com.sparta.jh.pages.HNWebPage;
import org.openqa.selenium.WebDriver;

public class HNCommentsPage extends HNWebPage  {
    private final WebDriver webDriver;

    public HNCommentsPage(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
    }
}
