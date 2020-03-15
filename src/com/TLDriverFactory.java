package com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Priyam on 14.03.2020.
 */
public class TLDriverFactory {

    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public synchronized static void setTLDriver (String browser) {
        System.out.println(browser);
        if (browser.equals("firefox")) {
            tlDriver = ThreadLocal.withInitial(() -> new FirefoxDriver(com.OptionsManager.getFirefoxOptions()));
        } else if (browser.equals("chrome")) {
            System.out.println(com.OptionsManager.getChromeOptions());
            tlDriver = ThreadLocal.withInitial(() -> new ChromeDriver(com.OptionsManager.getChromeOptions()));
        }
    }

    public synchronized static WebDriver getTLDriver () {
        return tlDriver.get();
    }

}
