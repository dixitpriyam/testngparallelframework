package com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;

/**
 * Created by Priyam on 14.03.2020.
 */
public class TestBase {

    protected WebDriverWait wait;
    @BeforeMethod
    @Parameters(value={"browser"})
    public void setupTest (@Optional String browser) throws MalformedURLException {
        TLDriverFactory.setTLDriver(browser);
        wait = new WebDriverWait(TLDriverFactory.getTLDriver(), 30);
    }

    @AfterMethod
    public synchronized void tearDown() throws Exception {
        TLDriverFactory.getTLDriver().quit();
    }

}
