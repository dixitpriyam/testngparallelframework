package com;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Priyam on 14.03.2020.
 */
public class FirstTest extends TestBase {

    @Test
    public void GOOGLE0() throws Exception {
        System.out.println("OpenAM Test Started! " + Thread.currentThread().getId());
        TLDriverFactory.getTLDriver().navigate().to("https://services.empirix.com/");
        System.out.println("Google0 Test's Page title is: " + TLDriverFactory.getTLDriver().getTitle() + " " + Thread.currentThread().getId());
        Assert.assertEquals(TLDriverFactory.getTLDriver().getTitle(), "OpenAM");
        Thread.sleep(20000);
        TLDriverFactory.getTLDriver().navigate().refresh();
        Thread.sleep(50000);
        TLDriverFactory.getTLDriver().findElement(By.xpath("//label[contains(text(),'Username')]//..//input")).sendKeys("QA_traininguser36");
        TLDriverFactory.getTLDriver().findElement(By.xpath("//label[contains(text(),'Password')]//..//input")).sendKeys("Empirix!");
        TLDriverFactory.getTLDriver().findElement(By.xpath("//input[@type='submit']")).click();
        System.out.println("OpenAM Test Ended! " + Thread.currentThread().getId());
//      Verify Dashboard:
        String _dashboard_="//a[@class!='VMENU' and @data-i18n='_dashboard_'] ";
        String _alerts_="//a[@class!='VMENU' and @data-i18n='_alerts_']";
        String _tests_="//a[@class!='VMENU' and @data-i18n='_tests_']";
        String _variables_="//a[@class!='VMENU' and @data-i18n='_variables_']";
        String _notifications_="//a[@class!='VMENU' and @data-i18n='_notifications_']";
        Thread.sleep(50000);
        Assert.assertEquals(TLDriverFactory.getTLDriver().findElement(By.xpath(_dashboard_)).getText(), "Dashboard");
        Assert.assertEquals(TLDriverFactory.getTLDriver().findElement(By.xpath(_alerts_)).getText(), "Alerts");
        Assert.assertEquals(TLDriverFactory.getTLDriver().findElement(By.xpath(_tests_)).getText(), "Tests");
        Assert.assertEquals(TLDriverFactory.getTLDriver().findElement(By.xpath(_variables_)).getText(), "Variables");
        Assert.assertEquals(TLDriverFactory.getTLDriver().findElement(By.xpath(_notifications_)).getText(), "Notifications");
        System.out.println("Title Verification Done");
        TLDriverFactory.getTLDriver().findElement(By.xpath("//a[@data-toggle='dropdown']")).click();
        TLDriverFactory.getTLDriver().findElement(By.xpath("//a[text()='Japanese']")).click();
        System.out.println("CLICK on Drop Down");
        // Switching to Alert
        Alert alert =  TLDriverFactory.getTLDriver().switchTo().alert();

        // Capturing alert message.
        String alertMessage=  TLDriverFactory.getTLDriver().switchTo().alert().getText();

        // Displaying alert message
        System.out.println(alertMessage);
        Thread.sleep(5000);

        // Accepting alert
        alert.accept();

        Thread.sleep(50000);
        Assert.assertEquals(TLDriverFactory.getTLDriver().findElement(By.xpath(_dashboard_)).getText(), "ダッシュボード");
        Assert.assertEquals(TLDriverFactory.getTLDriver().findElement(By.xpath(_alerts_)).getText(), "アラート");
        Assert.assertEquals(TLDriverFactory.getTLDriver().findElement(By.xpath(_tests_)).getText(), "テスト");
        Assert.assertEquals(TLDriverFactory.getTLDriver().findElement(By.xpath(_variables_)).getText(), "変数");
        Assert.assertEquals(TLDriverFactory.getTLDriver().findElement(By.xpath(_notifications_)).getText(), "通知");

        TLDriverFactory.getTLDriver().findElement(By.xpath("//a[@data-toggle='dropdown']")).click();
        TLDriverFactory.getTLDriver().findElement(By.xpath("//span[ @data-i18n='_client_']")).click();
        Thread.sleep(5000);

        Thread.sleep(50000);
        Assert.assertEquals(TLDriverFactory.getTLDriver().findElement(By.xpath("//label[ @data-i18n='_clientName_']" +
                "//following-sibling::label")).getText(), "Empirix_QA_Training");
        Assert.assertEquals(TLDriverFactory.getTLDriver().findElement(By.xpath("//label[ @data-i18n='_description_']" +
                "//following-sibling::label ")).getText(), "This client is for QA Test purposes");
        Assert.assertEquals(TLDriverFactory.getTLDriver().findElement(By.xpath("//label[ @data-i18n='_subscriptionStartDate_']" +
                "//following-sibling::label ")).getText(), "Jan 14, 2020");
        Assert.assertEquals(TLDriverFactory.getTLDriver().findElement(By.xpath("//label[ @data-i18n='_subscriptionEndDate_']" +
                "//following-sibling::label ")).getText(), "Aug 11, 2022");
        Assert.assertEquals(TLDriverFactory.getTLDriver().findElement(By.xpath("//label[ @data-i18n='_maximumLoadTests_']" +
                "//following-sibling::label ")).getText(), "0");
        Assert.assertEquals(TLDriverFactory.getTLDriver().findElement(By.xpath("//label[ @data-i18n='_maximumVoiceWatchTests_']" +
                "//following-sibling::label ")).getText(), "0");
        Assert.assertEquals(TLDriverFactory.getTLDriver().findElement(By.xpath("//label[ @data-i18n='_maximumScenarios_']" +
                "//following-sibling::label ")).getText(), "0");
        Assert.assertEquals(TLDriverFactory.getTLDriver().findElement(By.xpath("//label[ @data-i18n='_minimumTestSchedulePeriodMins_']" +
                "//following-sibling::label ")).getText(), "15");

        System.out.println("HURRAY: ALL THE TEST CASES PASSING");
    }

}
