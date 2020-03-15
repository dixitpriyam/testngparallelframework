package com;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by Priyam on 14.03.2020.
 */
public class DesiredCapsManager {

    public DesiredCapabilities getDesiredCapabilities (String browser, String platform) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        if (browser.equals("firefox")) {
            setFirefoxCapabilities(capabilities,browser);
        } else {
            capabilities.setCapability("platform", platform);
            capabilities.setCapability("browserName", browser);
        }

        return capabilities;
    }

    private void setFirefoxCapabilities (DesiredCapabilities capabilities, String browser) {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(false);
        profile.setPreference("network.proxy.type", 0);
        capabilities.setCapability(FirefoxDriver.PROFILE, profile);
    }
}
