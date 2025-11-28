package com.example.OrangeHRM.dong;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.fail;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class EndToEnd {
    private WebDriver driver;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private JavascriptExecutor js;
    private String baseUrl = "https://opensource-demo.orangehrmlive.com/";

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

    @Test(priority = 1, description = "Đăng nhập sai email")
    public void Admin_Login_01() throws Exception {
        driver.get("https://cms.anhtester.com/login");
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("wrong@example.com");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.get("https://cms.anhtester.com/admin");
        Thread.sleep(2000);
    }

    @Test(priority = 2, description = "Đăng nhập sai mật khẩu")
    public void Admin_Login_02() throws Exception {
        driver.get("https://cms.anhtester.com/login");
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("admin@example.com");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("wrongpwd");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.get("https://cms.anhtester.com/admin");
        Thread.sleep(2000);
    }

    @Test(priority = 3, description = "Đăng nhập sai email và mật khẩu")
    public void Admin_Login_03() throws Exception {
        driver.get("https://cms.anhtester.com/login");
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("bad@example.com");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("badpwd");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.get("https://cms.anhtester.com/admin");
        Thread.sleep(2000);
    }

    @Test(priority = 4, description = "bỏ trống trường email")
    public void Admin_Login_04() throws Exception {
        driver.get("https://cms.anhtester.com/login");
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.get("https://cms.anhtester.com/admin");
        Thread.sleep(2000);
    }

    @Test(priority = 5, description = "sử dụng mật khẩu có thêm inject query")
    public void Admin_Login_05() throws Exception {
        driver.get("https://cms.anhtester.com/login");
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("admin@example.com");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("wrongpwd \"' OR '1'='1");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.get("https://cms.anhtester.com/admin");
        Thread.sleep(2000);
    }

    @Test(priority = 6, description = "đăng nhập với mật khẩu trống")
    public void Admin_Login_06() throws Exception {
        driver.get("https://cms.anhtester.com/login");
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("admin@example.com");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.get("https://cms.anhtester.com/admin");
        Thread.sleep(2000);
    }

    @Test(priority = 7, description = "Đăng nhập đúng ")
    public void Admin_Login_07() throws Exception {
        driver.get("https://cms.anhtester.com/login");
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("admin@example.com");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.get("https://cms.anhtester.com/admin");
        Thread.sleep(2000);
    }

    @Test(priority = 8, description = "Thêm category với trường name")
    public void Category_Add_01() throws Exception {
        driver.get("https://cms.anhtester.com/admin");
        driver.findElement(By.xpath("//ul[@id='main-menu']/li[3]/a/span")).click();
        driver.findElement(By.xpath("//ul[@id='main-menu']/li[3]/ul/li[8]/a/span")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='All categories'])[1]/following::span[1]")).click();
        driver.findElement(By.id("name")).click();
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys("abcTest");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        try {
            assertEquals(driver.findElement(By.cssSelector(".aiz-notify span[data-notify=\"message\"]")).getText(), "Category has been inserted successfully");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        Thread.sleep(2000);
    }

    @Test(priority = 9, description = "Thêm category đã tồn tại name đó")
    public void Category_Add_02() throws Exception {
        driver.get("https://cms.anhtester.com/admin");
        driver.findElement(By.xpath("//ul[@id='main-menu']/li[3]/a/span")).click();
        driver.findElement(By.xpath("//ul[@id='main-menu']/li[3]/ul/li[8]/a/span")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='All categories'])[1]/following::span[1]")).click();
        driver.findElement(By.id("name")).click();
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys("abcTest");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        try {
            assertEquals(driver.findElement(By.cssSelector(".aiz-notify span[data-notify=\"message\"]")).getText(), "Category name already exists");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        Thread.sleep(2000);
    }

    @Test(priority = 10, description = "Thêm category bỏ trống trường name")
    public void Category_Add_03() throws Exception {
        driver.get("https://cms.anhtester.com/admin");
        driver.findElement(By.xpath("//ul[@id='main-menu']/li[3]/a/span")).click();
        driver.findElement(By.xpath("//ul[@id='main-menu']/li[3]/ul/li[8]/a/span")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='All categories'])[1]/following::span[1]")).click();
        driver.findElement(By.id("name")).click();
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys("");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        try {
            assertTrue(isElementPresent(By.cssSelector("input#name:invalid")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        Thread.sleep(2000);
    }


    @Test(priority = 11, description = "thêm category đầy đủ")
    public void Category_Add_04() throws Exception {
        driver.get("https://cms.anhtester.com/admin");
        driver.findElement(By.xpath("//ul[@id='main-menu']/li[3]/a/span")).click();
        driver.findElement(By.xpath("//ul[@id='main-menu']/li[3]/ul/li[8]/a/span")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='All categories'])[1]/following::span[1]")).click();
        driver.findElement(By.id("name")).click();
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys("abcTest");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Parent Category'])[1]/following::div[5]")).click();
        driver.findElement(By.xpath("//a[@id='bs-select-1-1']/span")).click();
        new Select(driver.findElement(By.name("parent_id"))).selectByVisibleText("Sport shoes");
        driver.findElement(By.id("order_level")).click();
        driver.findElement(By.id("order_level")).clear();
        driver.findElement(By.id("order_level")).sendKeys("10");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Type'])[1]/following::div[5]")).click();
        driver.findElement(By.id("bs-select-2-1")).click();
        new Select(driver.findElement(By.name("digital"))).selectByVisibleText("Digital");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='(200x200)'])[1]/following::div[4]")).click();
        driver.findElement(By.xpath("//div[@id='aiz-select-file']/div[2]/div/div/div/div/img")).click();
        driver.findElement(By.xpath("//div[@id='aizUploaderModal']/div/div/div[3]/button")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='(32x32)'])[1]/following::div[4]")).click();
        driver.findElement(By.xpath("//div[@id='aiz-select-file']/div[2]/div/div/div/div/img")).click();
        driver.findElement(By.xpath("//div[@id='aizUploaderModal']/div/div/div[3]/button")).click();
        driver.findElement(By.name("meta_title")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Filtering Attributes'])[1]/following::div[5]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Filtering Attributes'])[1]/following::div[5]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Filtering Attributes'])[1]/following::div[5]")).click();
        driver.findElement(By.id("bs-select-3-0")).click();
        new Select(driver.findElement(By.name("filtering_attributes[]"))).selectByVisibleText("Size");
        //ERROR: Caught exception [ERROR: Unsupported command [removeSelection | name=filtering_attributes[] | label=Quality]]
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Quality'])[2]/following::div[1]")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Test(priority = 12, description = "chỉnh sửa tên của category")
    public void Category_Edit_01() throws Exception {
        driver.get("https://cms.anhtester.com/admin/categories");
        driver.findElement(By.xpath("//td[10]/a/i")).click();
        driver.findElement(By.id("name")).click();
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys("Test12345");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        try {
            assertEquals(driver.findElement(By.cssSelector(".aiz-notify span[data-notify=\"message\"]")).getText(), "Category has been updated successfully");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        Thread.sleep(2000);
    }


    @Test(priority = 13, description = "chỉnh sửa tên của category bằng cách bổ trống trường")
    public void Category_Edit_02() throws Exception {
        driver.get("https://cms.anhtester.com/admin/categories");
        driver.findElement(By.xpath("//td[10]/a/i")).click();
        driver.findElement(By.id("name")).click();
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys("");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        try {
            assertTrue(isElementPresent(By.cssSelector("input#name:invalid")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        Thread.sleep(2000);
    }

    @Test(priority = 14, description = "chỉnh sửa lại ảnh của category")
    public void Category_Edit_03() throws Exception {
        driver.get("https://cms.anhtester.com/admin");
        driver.findElement(By.xpath("//ul[@id='main-menu']/li[3]/a/span")).click();
        driver.findElement(By.xpath("//ul[@id='main-menu']/li[3]/ul/li[8]/a/span")).click();
        driver.findElement(By.xpath("//td[10]/a/i")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='(200x200)'])[1]/following::div[4]")).click();
        driver.findElement(By.xpath("//div[@id='aiz-select-file']/div[2]/div[2]/div/div/div/img")).click();
        driver.findElement(By.xpath("//div[@id='aizUploaderModal']/div/div/div[3]/button")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        try {
            assertEquals(driver.findElement(By.cssSelector(".aiz-notify span[data-notify=\"message\"]")).getText(), "Category has been updated successfully");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @Test(priority = 15, description = "tìm kiếm category tồn tại")
    public void Category_Search_01() throws Exception {
        driver.get("https://cms.anhtester.com/admin");
        driver.findElement(By.xpath("//ul[@id='main-menu']/li[3]/a/span")).click();
        driver.findElement(By.xpath("//ul[@id='main-menu']/li[3]/ul/li[8]/a/span")).click();
        driver.findElement(By.id("search")).click();
        driver.findElement(By.id("search")).clear();
        driver.findElement(By.id("search")).sendKeys("Test123");
        driver.findElement(By.id("sort_categories")).submit();
        Thread.sleep(2000);
    }

    @Test(priority = 16, description = "tìm kiếm category không tồn tại")
    public void Category_Search_02() throws Exception {
        driver.get("https://cms.anhtester.com/admin");
        driver.findElement(By.xpath("//ul[@id='main-menu']/li[3]/a/span")).click();
        driver.findElement(By.xpath("//ul[@id='main-menu']/li[3]/ul/li[8]/a/span")).click();
        driver.findElement(By.id("search")).click();
        driver.findElement(By.id("search")).clear();
        driver.findElement(By.id("search")).sendKeys("Test123scsaa");
        driver.findElement(By.id("sort_categories")).submit();
        try {
            assertEquals(driver.findElement(By.xpath("//tr[@class='footable-empty']/td")).getText(), "Nothing found");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        Thread.sleep(2000);
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

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
