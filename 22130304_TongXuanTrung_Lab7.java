package com.example.OrangeHRM.trung;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.fail;

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

    @Test(priority = 1, description = "Tìm kiếm với từ khóa giống với sản phẩm đang tồn tại")
    public void User_SearchProduct_01() throws Exception {
        driver.get("https://cms.anhtester.com/");
        driver.findElement(By.id("search")).click();
        driver.findElement(By.id("search")).clear();
        driver.findElement(By.id("search")).sendKeys("Cosy Hai Yen AODXUMXT");
        driver.findElement(By.cssSelector(".stop-propagation")).submit();
        driver.findElement(By.id("search")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 2, description = "Tìm kiếm sản phẩm với từ khóa có dấu tiếng Việt")
    public void User_SearchProduct_02() throws Exception {
        driver.get("https://cms.anhtester.com/");
        driver.findElement(By.id("search")).click();
        driver.findElement(By.id("search")).clear();
        driver.findElement(By.id("search")).sendKeys("bánh");
        driver.findElement(By.cssSelector(".stop-propagation")).submit();
        Thread.sleep(5000);
    }

    @Test(priority = 3, description = "Tìm kiếm sản phẩm với từ khóa có dấu tiếng Anh")
    public void User_SearchProduct_03() throws Exception {
        driver.get("https://cms.anhtester.com/");
        driver.findElement(By.id("search")).click();
        driver.findElement(By.id("search")).clear();
        driver.findElement(By.id("search")).sendKeys("bánh");
        driver.findElement(By.cssSelector(".stop-propagation")).submit();
        Thread.sleep(5000);
    }

    @Test(priority = 4, description = "Tìm kiếm sản phẩm không tồn tại")
    public void User_SearchProduct_04() throws Exception {
        driver.get("https://cms.anhtester.com/");
        driver.findElement(By.id("search")).click();
        driver.findElement(By.id("search")).clear();
        driver.findElement(By.id("search")).sendKeys("super sushi");
        driver.findElement(By.cssSelector(".stop-propagation")).submit();
        Thread.sleep(5000);
    }

    @Test(priority = 5, description = "Tìm kiếm sản phẩm với từ khóa có ký tự đặc biệt")
    public void User_SearchProduct_05() throws Exception {
        driver.get("https://cms.anhtester.com/");
        driver.findElement(By.id("search")).click();
        driver.findElement(By.id("search")).clear();
        driver.findElement(By.id("search")).sendKeys("a@312_()(*");
        driver.findElement(By.cssSelector(".stop-propagation")).submit();
        Thread.sleep(5000);
    }

    @Test(priority = 6, description = "Tìm kiếm sản phẩm với từ khóa rỗng")
    public void User_SearchProduct_06() throws Exception {
        driver.get("https://cms.anhtester.com/");
        driver.findElement(By.id("search")).click();
        driver.findElement(By.id("search")).clear();
        driver.findElement(By.id("search")).sendKeys("");
        driver.findElement(By.cssSelector(".stop-propagation")).submit();
        Thread.sleep(5000);
    }

    @Test(priority = 7, description = "Tìm kiếm sản phẩm với từ khóa dài")
    public void User_SearchProduct_07() throws Exception {
        driver.get("https://cms.anhtester.com/");
        driver.findElement(By.id("search")).click();
        driver.findElement(By.id("search")).clear();
        driver.findElement(By.id("search")).sendKeys("qwertyuiopasdfghjklqwertyuiopasdfghjklqwertyuiopasdfghjklqwertyuiopasdfghjklqwertyuiopasdfghjkl");
        driver.findElement(By.cssSelector(".stop-propagation")).submit();
        Thread.sleep(5000);
    }

    @Test(priority = 8, description = "Thêm Selller Packages với thông tin hợp lệ")
    public void Seller_AddPackage_01() throws Exception {
        driver.get("https://cms.anhtester.com/admin");
        driver.findElement(By.xpath("//ul[@id='main-menu']/li[6]/a/span")).click();
        driver.findElement(By.xpath("//ul[@id='main-menu']/li[6]/ul/li[5]/a/span")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='All Seller Packages'])[1]/following::span[1]")).click();
        driver.findElement(By.id("name")).click();
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys("Pack A");
        driver.findElement(By.id("amount")).click();
        driver.findElement(By.id("amount")).clear();
        driver.findElement(By.id("amount")).sendKeys("20");
        driver.findElement(By.id("product_upload_limit")).click();
        driver.findElement(By.id("product_upload_limit")).clear();
        driver.findElement(By.id("product_upload_limit")).sendKeys("20");
        driver.findElement(By.id("duration")).click();
        driver.findElement(By.id("duration")).clear();
        driver.findElement(By.id("duration")).sendKeys("60");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Package Logo'])[1]/following::div[4]")).click();
        driver.findElement(By.xpath("//div[@id='aiz-select-file']/div[2]/div/div/div/div[2]")).click();
        driver.findElement(By.xpath("//div[@id='aizUploaderModal']/div/div/div[3]/button")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Test(priority = 9, description = "Thêm Selller Packages với thông tin rỗng")
    public void Seller_AddPackage_02() throws Exception {
        driver.get("https://cms.anhtester.com/admin/seller_packages");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='All Seller Packages'])[1]/following::span[1]")).click();
        driver.findElement(By.id("name")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.id("amount")).click();
        driver.findElement(By.id("amount")).clear();
        driver.findElement(By.id("amount")).sendKeys("");
        driver.findElement(By.id("product_upload_limit")).click();
        driver.findElement(By.id("product_upload_limit")).clear();
        driver.findElement(By.id("product_upload_limit")).sendKeys("");
        driver.findElement(By.id("duration")).click();
        driver.findElement(By.id("duration")).clear();
        driver.findElement(By.id("duration")).sendKeys("");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Test(priority = 10, description = "Thêm Selller Packages với thông tin là chữ (trừ Package Name)")
    public void Seller_AddPackage_03() throws Exception {
        driver.get("https://cms.anhtester.com/admin/seller_packages");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='All Seller Packages'])[1]/following::span[1]")).click();
        driver.findElement(By.id("name")).click();
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys("Pack chữ");
        driver.findElement(By.id("amount")).click();
        driver.findElement(By.id("amount")).clear();
        driver.findElement(By.id("amount")).sendKeys("abc");
        driver.findElement(By.id("product_upload_limit")).click();
        driver.findElement(By.id("product_upload_limit")).clear();
        driver.findElement(By.id("product_upload_limit")).sendKeys("abc");
        driver.findElement(By.id("duration")).click();
        driver.findElement(By.id("duration")).clear();
        driver.findElement(By.id("duration")).sendKeys("abc");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Test(priority = 11, description = "Chỉnh sửa thông tin Selller Packages với thông tin hợp lệ")
    public void Seller_EditPackage_01() throws Exception {
        driver.get("https://cms.anhtester.com/admin/seller_packages");
        driver.findElement(By.linkText("Edit")).click();
        driver.findElement(By.id("name")).click();
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys("Pack zero");
        driver.findElement(By.id("amount")).click();
        driver.findElement(By.id("amount")).clear();
        driver.findElement(By.id("amount")).sendKeys("200");
        driver.findElement(By.id("product_upload_limit")).click();
        driver.findElement(By.id("product_upload_limit")).clear();
        driver.findElement(By.id("product_upload_limit")).sendKeys("201");
        driver.findElement(By.id("duration")).click();
        driver.findElement(By.id("duration")).clear();
        driver.findElement(By.id("duration")).sendKeys("600");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Test(priority = 12, description = "Chỉnh sửa thông tin Selller Packages với thông tin rỗng")
    public void Seller_EditPackage_02() throws Exception {
        driver.get("https://cms.anhtester.com/admin/seller_packages");
        driver.findElement(By.linkText("Edit")).click();
        driver.findElement(By.id("name")).click();
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys("Pack zero");
        driver.findElement(By.id("amount")).click();
        driver.findElement(By.id("amount")).clear();
        driver.findElement(By.id("amount")).sendKeys("");
        driver.findElement(By.id("product_upload_limit")).click();
        driver.findElement(By.id("product_upload_limit")).clear();
        driver.findElement(By.id("product_upload_limit")).sendKeys("");
        driver.findElement(By.id("duration")).click();
        driver.findElement(By.id("duration")).clear();
        driver.findElement(By.id("duration")).sendKeys("");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Test(priority = 13, description = "Chỉnh sửa thông tin Selller Packages với với thông tin là chữ (trừ Package Name)")
    public void Seller_EditPackage_03() throws Exception {
        driver.get("https://cms.anhtester.com/admin/seller_packages");
        driver.findElement(By.linkText("Edit")).click();
        driver.findElement(By.id("name")).click();
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys("Pack zero");
        driver.findElement(By.id("amount")).click();
        driver.findElement(By.id("amount")).clear();
        driver.findElement(By.id("amount")).sendKeys("200");
        driver.findElement(By.id("product_upload_limit")).click();
        driver.findElement(By.id("product_upload_limit")).clear();
        driver.findElement(By.id("product_upload_limit")).sendKeys("abc");
        driver.findElement(By.id("duration")).click();
        driver.findElement(By.id("duration")).clear();
        driver.findElement(By.id("duration")).sendKeys("abc");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Test(priority = 14, description = "Xóa Selller Packages đang tồn tại")
    public void Seller_removePackage_01() throws Exception {
        driver.get("https://cms.anhtester.com/admin/seller_packages");
        driver.findElement(By.linkText("Delete")).click();
        driver.findElement(By.id("delete-link")).click();
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
