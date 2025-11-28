package com.example.AmazCartCMS;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.*;

public class TestSuite {
    private WebDriver driver;
    private StringBuffer verificationErrors = new StringBuffer();
    private JavascriptExecutor js;
    private String baseUrl = "https://cms.anhtester.com/admin";

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
    }
    @Test(priority = 1, description = "Test Login thành công với tài khoản Admin")
    public void testLoginCredentials() throws Exception {
        driver.get("https://cms.anhtester.com/login");
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("admin@example.com");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.get("https://cms.anhtester.com/admin");
    }
    @Test(priority = 2, description = "Test Hiển thị danh sách All Sellers")
    public void testAllSellersViewList01() throws Exception {
        driver.get("https://cms.anhtester.com/admin");
        driver.findElement(By.xpath("//ul[@id='main-menu']/li[6]/a/span")).click();
        driver.findElement(By.xpath("//ul[@id='main-menu']/li[6]/ul/li/a/span")).click();
        try {
            assertTrue(isElementPresent(By.xpath("//th[contains(text(),'Name')]")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @Test(priority = 3, description = "Test Xem chi tiết seller")
    public void testAllSellersViewSellerDetail02() throws Exception {
        driver.get("https://cms.anhtester.com/admin/sellers");
        driver.findElement(By.xpath("//form[@id='sort_sellers']/div[2]/table/tbody/tr/td[2]")).click();
        //Warning: verifyTextPresent may require manual changes
        try {
            assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Phone[\\s\\S]*$"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        //Warning: verifyTextPresent may require manual changes
        try {
            assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Email Address[\\s\\S]*$"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        //Warning: verifyTextPresent may require manual changes
        try {
            assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Verification Info[\\s\\S]*$"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        //Warning: verifyTextPresent may require manual changes
        try {
            assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Approval[\\s\\S]*$"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        //Warning: verifyTextPresent may require manual changes
        try {
            assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Num\\. of Products[\\s\\S]*$"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        //Warning: verifyTextPresent may require manual changes
        try {
            assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Due to seller[\\s\\S]*$"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @Test(priority = 4, description = "Test Search theo Email")
    public void testAllSellersSearchByEmail03() throws Exception {
        driver.get("https://cms.anhtester.com/admin/sellers");
        driver.findElement(By.id("search")).click();
        driver.findElement(By.id("search")).clear();
        driver.findElement(By.id("search")).sendKeys("f11@gmail.com");
        driver.findElement(By.id("sort_sellers")).submit();
        isElementPresent(By.xpath("//tbody/tr"));
        //ERROR: Caught exception [unknown command [verifyElementPresent  ]]
    }

    @Test(priority = 5, description = "TestSearch không có kết quả")
    public void testAllSellersSearchNoResult04() throws Exception {
        driver.get("https://cms.anhtester.com/admin/sellers");
        driver.findElement(By.id("search")).click();
        driver.findElement(By.id("search")).clear();
        driver.findElement(By.id("search")).sendKeys("ABCXYZ123");
        driver.findElement(By.id("sort_sellers")).submit();
        //Warning: verifyTextPresent may require manual changes
        try {
            assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Nothing found[\\s\\S]*$"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @Test(priority = 6, description = "Test Filter theo Approval/ Non-Approved")
    public void testAllSellersFilterByApproval05() throws Exception {
        driver.get("https://cms.anhtester.com/admin/sellers");
        driver.findElement(By.xpath("//button[@data-id='approved_status']")).click();
        driver.findElement(By.id("bs-select-1-1")).click();
        Thread.sleep(2000);
        Number totalRows = driver.findElements(By.xpath("//tbody/tr")).size();
        Number approvedCount = driver.findElements(By.xpath("//tbody//tr//td[6]//input[@type='checkbox' and @checked]")).size();
        String result = (String) js.executeScript("var totalRows = \"" + totalRows + "\";var approvedCount = \"" + approvedCount + "\";var storedVars = { 'totalRows': totalRows,'approvedCount': approvedCount }; return " + "(function() { if (" + approvedCount + " == " + totalRows + ") return true; else throw 'Mismatch: approved=' + " + approvedCount + " + ', total=' + " + totalRows + "; })();" + "");
        driver.findElement(By.xpath("//button[@data-id='approved_status']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@id='bs-select-1-2']/span")).click();
        Thread.sleep(2000);
        approvedCount = driver.findElements(By.xpath("//tbody//tr//td[6]//input[@type='checkbox' and @checked]")).size();
        String result2 = (String) js.executeScript("var totalRows = \"" + totalRows + "\";var approvedCount = \"" + approvedCount + "\";var result = \"" + result + "\";var storedVars = { 'totalRows': totalRows,'approvedCount': approvedCount,'result': result }; return " + "(function() { if (" + approvedCount + " == 0) return true; else throw 'Non-approved expected 0 but found ' + " + approvedCount + "; })();" + "");
    }

    @Test(priority = 7, description = "Test Edit seller hợp lệ")
    public void testAllSellersEditSeller06() throws Exception {
        driver.get("https://cms.anhtester.com/admin/sellers");
        driver.findElement(By.xpath("//form[@id='sort_sellers']/div[2]/table/tbody/tr/td[9]/div/button")).click();
        driver.findElement(By.linkText("Edit")).click();
        driver.findElement(By.id("name")).click();
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys("Cam Tu");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("12345");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        //Warning: verifyTextPresent may require manual changes
        try {
            assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Seller has been updated successfully[\\s\\S]*$"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @Test(priority = 8, description = "Test Edit với Name rỗng")
    public void testAllSellersEditSeller07() throws Exception {
        driver.get("https://cms.anhtester.com/admin/sellers");
        driver.findElement(By.xpath("//form[@id='sort_sellers']/div[2]/table/tbody/tr/td[9]/div/button")).click();
        driver.findElement(By.linkText("Edit")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Name'])[1]/following::div[1]")).click();
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys("");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        String isMissing = (String) js.executeScript(" return " + "document.getElementById('name').validity.valueMissing;" + "");
        try {
            assertEquals(js.executeScript("var isMissing = \"" + isMissing + "\";var storedVars = { 'isMissing': isMissing }; return " + isMissing + ""), "true");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @Test(priority = 9, description = "Test Xóa seller")
    public void testAllSellersDeleteSeller08() throws Exception {
        driver.get("https://cms.anhtester.com/admin/sellers");
        driver.findElement(By.xpath("//form[@id='sort_sellers']/div[2]/table/tbody/tr/td[9]/div/button/i")).click();
        driver.findElement(By.linkText("Delete")).click();
        driver.findElement(By.id("delete-link")).click();
        //Warning: verifyTextPresent may require manual changes
        try {
            assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Seller has been deleted successfully[\\s\\S]*$"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @Test(priority = 10, description = "Test Mở Seller Verification Form (form builder)")
    public void testSellerVerificationViewForm09() throws Exception {
        driver.get("https://cms.anhtester.com/admin/sellers");
        driver.findElement(By.xpath("//ul[@id='main-menu']/li[6]/ul/li[6]/a/span")).click();
        driver.get("https://cms.anhtester.com/admin/verification/form");
        try {
            assertEquals(driver.findElement(By.xpath("//h5[contains(text(),'Seller Verification Form')]")).getText(), "Seller Verification Form");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertTrue(isElementPresent(By.xpath("//label[contains(text(),'Select')]")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertTrue(isElementPresent(By.xpath("//input[@name='label[]' and @value='Check is person?']")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertTrue(isElementPresent(By.xpath("//input[@name='options_0[]' and @value='Yes']")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertTrue(isElementPresent(By.xpath("//input[@name='options_0[]' and @value='No']")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertTrue(isElementPresent(By.xpath("//li[contains(text(),'Text Input')]")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertTrue(isElementPresent(By.xpath("//li[contains(text(),'Select')]")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertTrue(isElementPresent(By.xpath("//li[contains(text(),'Multiple Select')]")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertTrue(isElementPresent(By.xpath("//li[contains(text(),'Radio')]")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertTrue(isElementPresent(By.xpath("//li[contains(text(),'File')]")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @Test(priority = 11, description = "Test Kiểm tra khả năng chỉnh sửa thông tin của các field đã có sẵn trong Seller Verification Form.")
    public void testSellerVerificationEditExistingField10() throws Exception {
        driver.get("https://cms.anhtester.com/admin/verification/form");
        driver.findElement(By.name("label[]")).click();
        driver.findElement(By.name("label[]")).clear();
        driver.findElement(By.name("label[]")).sendKeys("How satisfied are you with our service?");
        driver.findElement(By.name("options_0[]")).click();
        driver.findElement(By.name("options_0[]")).clear();
        driver.findElement(By.name("options_0[]")).sendKeys("Very satisfied");
        driver.findElement(By.xpath("//div[@id='form']/div/div[2]/div/div[2]/div/input")).click();
        driver.findElement(By.xpath("//div[@id='form']/div/div[2]/div/div[2]/div/input")).clear();
        driver.findElement(By.xpath("//div[@id='form']/div/div[2]/div/div[2]/div/input")).sendKeys("Satisfied");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        //Warning: verifyTextPresent may require manual changes
        try {
            assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Verification form updated successfully[\\s\\S]*$"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @Test(priority = 12, description = "Test Save form builder hợp lệ")
    public void testSellerVerificationSaveForm11() throws Exception {
        driver.get("https://cms.anhtester.com/admin/verification/form");
        driver.findElement(By.xpath("//button[@type='button']")).click();
        driver.findElement(By.xpath("//div[@id='form']/div/div[2]/div/div[3]/div/input")).click();
        driver.findElement(By.xpath("//div[@id='form']/div/div[2]/div/div[3]/div/input")).clear();
        driver.findElement(By.xpath("//div[@id='form']/div/div[2]/div/div[3]/div/input")).sendKeys("Neutral");
        driver.findElement(By.xpath("//button[@type='button']")).click();
        driver.findElement(By.xpath("//div[@id='form']/div/div[2]/div/div[4]/div/input")).click();
        driver.findElement(By.xpath("//div[@id='form']/div/div[2]/div/div[4]/div/input")).clear();
        driver.findElement(By.xpath("//div[@id='form']/div/div[2]/div/div[4]/div/input")).sendKeys("Dissatisfied");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        //Warning: verifyTextPresent may require manual changes
        try {
            assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Verification form updated successfully[\\s\\S]*$"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }


    @Test(priority = 13, description = "Test Submit builder khi field required trống")
    public void testSellerVerificationValidateMissing12() throws Exception {
        driver.get("https://cms.anhtester.com/admin/verification/form");
        driver.findElement(By.xpath("//div[@id='form']/div/div[2]/div/div[4]/div/input")).click();
        driver.findElement(By.xpath("//div[@id='form']/div/div[2]/div/div[4]/div/input")).clear();
        driver.findElement(By.xpath("//div[@id='form']/div/div[2]/div/div[4]/div/input")).sendKeys("");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        String defaultValue = (String) driver.findElement(By.xpath("//input[@name='options_0[]']")).getAttribute("value");
        //ERROR: Caught exception [unknown command [echo  ]]
    }


    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        if (driver != null) {
            driver.quit();
        }
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}