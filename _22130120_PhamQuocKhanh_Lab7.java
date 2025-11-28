import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class _22130120_PhamQuocKhanh_Lab7 {

  private static WebDriver driver;
  private static final String baseUrl = "https://cms.anhtester.com/";
  private final StringBuffer verificationErrors = new StringBuffer();

  private static final String USERNAME = "admin@example.com";
  private static final String PASSWORD = "123456";

  private JavascriptExecutor js;

  @BeforeClass
  public static void setUp() throws Exception {
    WebDriverManager.chromedriver().setup();

    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    driver.get(baseUrl + "admin");

    driver.findElement(By.id("email")).sendKeys(USERNAME);
    Thread.sleep(1000);
    driver.findElement(By.id("password")).sendKeys(PASSWORD);
    Thread.sleep(1000);
    driver.findElement(By.xpath("//button[@type='submit']")).click();

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
  }

  @Test
  public void testALLORDFILTER01() throws Exception {
    driver.get(baseUrl + "admin/all_orders");
    Thread.sleep(1000);

    driver.findElement(By.xpath("//form[@id='sort_orders']/div/div[3]/div/button")).click();
    Thread.sleep(1000);
    driver.findElement(By.id("bs-select-1-1")).click();
    Thread.sleep(1000);

    driver.findElement(By.xpath("//button[@type='submit']")).click();

    Thread.sleep(2000);
  }

  @Test
  public void testALLORDFILTER02() throws Exception {
    driver.get(baseUrl + "admin/all_orders");
    Thread.sleep(1000);

    driver.findElement(By.xpath("//form[@id='sort_orders']/div/div[3]/div/button/div/div/div")).click();
    Thread.sleep(1000);
    driver.findElement(By.id("bs-select-1-2")).click();
    Thread.sleep(1000);

    driver.findElement(By.xpath("//button[@type='submit']")).click();
    Thread.sleep(2000);
  }

  @Test
  public void testALLORDFILTER03() throws Exception {
    driver.get(baseUrl + "admin/all_orders");
    Thread.sleep(1000);

    driver.findElement(By.xpath("//form[@id='sort_orders']/div/div[3]/div/button/div/div/div")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//a[@id='bs-select-1-3']/span")).click();
    Thread.sleep(1000);

    driver.findElement(By.xpath("//button[@type='submit']")).click();
    Thread.sleep(2000);
  }

  @Test
  public void testALLORDFILTER04() throws Exception {
    driver.get(baseUrl + "admin/all_orders");
    Thread.sleep(1000);

    driver.findElement(By.xpath("//form[@id='sort_orders']/div/div[3]/div/button/div/div/div")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//a[@id='bs-select-1-4']/span")).click();
    Thread.sleep(1000);

    driver.findElement(By.xpath("//button[@type='submit']")).click();
    Thread.sleep(2000);
  }

  @Test
  public void testALLORDFILTER05() throws Exception {
    driver.get(baseUrl + "admin/all_orders");
    Thread.sleep(1000);

    driver.findElement(By.xpath("//form[@id='sort_orders']/div/div[3]/div/button/div/div/div")).click();
    Thread.sleep(1000);
    driver.findElement(By.id("bs-select-1-5")).click();
    Thread.sleep(1000);

    driver.findElement(By.xpath("//button[@type='submit']")).click();
    Thread.sleep(2000);
  }

  @Test
  public void testALLORDFILTER06() throws Exception {
    driver.get(baseUrl + "admin/all_orders");
    Thread.sleep(1000);

    driver.findElement(By.xpath("//form[@id='sort_orders']/div/div[3]/div/button/div/div/div")).click();
    Thread.sleep(1000);
    driver.findElement(By.id("bs-select-1-6")).click();
    Thread.sleep(1000);

    driver.findElement(By.xpath("//button[@type='submit']")).click();
    Thread.sleep(2000);
  }

  @Test
  public void testALLORDFILTER07() throws Exception {
    driver.get(baseUrl + "admin/all_orders");
    Thread.sleep(1000);

    driver.findElement(By.xpath("//form[@id='sort_orders']/div/div[4]/div/button")).click();
    Thread.sleep(1000);
    driver.findElement(By.id("bs-select-2-1")).click();
    Thread.sleep(1000);

    driver.findElement(By.xpath("//button[@type='submit']")).click();
    Thread.sleep(2000);
  }

  @Test
  public void testALLORDFILTER08() throws Exception {
    driver.get(baseUrl + "admin/all_orders");
    Thread.sleep(1000);

    driver.findElement(By.xpath("//form[@id='sort_orders']/div/div[4]/div/button/div/div/div")).click();
    Thread.sleep(1000);
    driver.findElement(By.id("bs-select-2-2")).click();
    Thread.sleep(1000);

    driver.findElement(By.xpath("//button[@type='submit']")).click();
    Thread.sleep(2000);
  }

  @Test
  public void testALLORDFILTER09() throws Exception {
    driver.get(baseUrl + "admin/all_orders");
    Thread.sleep(1000);

    driver.findElement(By.name("date")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Today'])[1]/following::li[1]")).click();
    Thread.sleep(1000);

    driver.findElement(By.xpath("//button[@type='submit']")).click();
    Thread.sleep(2000);
  }

  @Test
  public void testALLORDFILTER10() throws Exception {
    driver.get(baseUrl + "admin/all_orders");
    Thread.sleep(1000);

    driver.findElement(By.name("date")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Yesterday'])[1]/following::li[1]")).click();
    Thread.sleep(1000);

    driver.findElement(By.xpath("//button[@type='submit']")).click();
    Thread.sleep(2000);
  }

  @Test
  public void testALLORDFILTER11() throws Exception {
    driver.get(baseUrl + "admin/all_orders");
    Thread.sleep(1000);

    driver.findElement(By.name("date")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Last 7 Days'])[1]/following::li[1]")).click();
    Thread.sleep(1000);

    driver.findElement(By.xpath("//button[@type='submit']")).click();
    Thread.sleep(2000);
  }

  @Test
  public void testALLORDFILTER12() throws Exception {
    driver.get(baseUrl + "admin/all_orders");
    Thread.sleep(1000);

    driver.findElement(By.name("date")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Last 30 Days'])[1]/following::li[1]")).click();
    Thread.sleep(1000);

    driver.findElement(By.xpath("//button[@type='submit']")).click();
    Thread.sleep(2000);
  }

  @Test
  public void testALLORDFILTER13() throws Exception {
    driver.get(baseUrl + "admin/all_orders");
    Thread.sleep(1000);

    driver.findElement(By.xpath("//form[@id='sort_orders']/div/div[3]/div/button/div/div/div")).click();
    Thread.sleep(1000);
    driver.findElement(By.id("bs-select-1-1")).click();

    driver.findElement(By.xpath("//form[@id='sort_orders']/div/div[4]/div/button/div/div/div")).click();
    Thread.sleep(1000);
    driver.findElement(By.id("bs-select-2-2")).click();

    driver.findElement(By.name("date")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Yesterday'])[1]/following::li[1]")).click();

    driver.findElement(By.xpath("//button[@type='submit']")).click();
    Thread.sleep(2000);
  }

  @Test
  public void testALLORDDELETE01() throws Exception {
    driver.get(baseUrl + "admin/all_orders");
    Thread.sleep(1000);

    driver.findElement(By.xpath("//form[@id='sort_orders']/div[2]/table/tbody/tr/td[10]/a[3]/i")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//div[@id='delete-modal']/div/div/div[2]/button")).click();
    Thread.sleep(2000);
  }

  @Test
  public void testALLORDDELETE02() throws Exception {
    driver.get(baseUrl + "admin/all_orders");
    Thread.sleep(1000);

    driver.findElement(By.xpath("//form[@id='sort_orders']/div[2]/table/tbody/tr[2]/td[10]/a[3]")).click();
    Thread.sleep(1000);
    driver.findElement(By.id("delete-link")).click();
    Thread.sleep(2000);
  }

  @Test
  public void testALLORDDELETE03() throws Exception {
    driver.get(baseUrl + "admin/all_orders");
    Thread.sleep(1000);

    driver.findElement(By.linkText("2")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//form[@id='sort_orders']/div[2]/table/tbody/tr[2]/td/div/div/label/span")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//form[@id='sort_orders']/div[2]/table/tbody/tr/td/div/div/label/span")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//form[@id='sort_orders']/div[2]/table/tbody/tr/td[10]/a[3]/i")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//div[@id='delete-modal']/div/div/div[2]/button")).click();
    Thread.sleep(2000);
  }

  @Test
  public void testALLORDDELETE04() throws Exception {
    driver.get(baseUrl + "admin/all_orders");
    Thread.sleep(1000);

    driver.findElement(By.linkText("2")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//form[@id='sort_orders']/div[2]/table/tbody/tr/td/div/div/label/span")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//form[@id='sort_orders']/div[2]/table/tbody/tr[2]/td/div/div/label/span")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//form[@id='sort_orders']/div[2]/table/tbody/tr/td[10]/a[3]/i")).click();
    Thread.sleep(1000);
    driver.findElement(By.id("delete-link")).click();
    Thread.sleep(2000);
  }


  @Test
  public void testALLORDVIEW01() throws Exception {
    driver.get(baseUrl + "admin/all_orders");
    Thread.sleep(1000);

    driver.findElement(By.xpath("//form[@id='sort_orders']/div[2]/table/tbody/tr/td[10]/a/i")).click();
    Thread.sleep(2000);
  }

  @Test
  public void testALLORDDOWNLOAD01() throws Exception {
    driver.get(baseUrl + "admin/all_orders");
    Thread.sleep(1000);

    driver.findElement(By.xpath("//form[@id='sort_orders']/div[2]/table/tbody/tr/td[10]/a[2]")).click();
    Thread.sleep(2000);
  }

// -----------------------------------------------------------------------------------------------------------------------------------

  @Test
  public void testINORDERFILTER01() throws Exception {
    driver.get(baseUrl + "admin/inhouse-orders");
    Thread.sleep(1000);

    driver.findElement(By.xpath("//form[@id='sort_orders']/div/div[3]/div/button/div/div/div")).click();
    Thread.sleep(1000);
    driver.findElement(By.id("bs-select-1-1")).click();
    Thread.sleep(1000);

    driver.findElement(By.xpath("//button[@type='submit']")).click();
    Thread.sleep(2000);
  }

  @Test
  public void testINORDERFILTER02() throws Exception {
    driver.get(baseUrl + "admin/inhouse-orders");
    Thread.sleep(1000);

    driver.findElement(By.xpath("//form[@id='sort_orders']/div/div[3]/div/button")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//a[@id='bs-select-1-2']/span")).click();
    Thread.sleep(1000);

    driver.findElement(By.xpath("//button[@type='submit']")).click();
    Thread.sleep(2000);
  }

  @Test
  public void testINORDERFILTER03() throws Exception {
    driver.get(baseUrl + "admin/inhouse-orders");
    Thread.sleep(1000);

    driver.findElement(By.xpath("//form[@id='sort_orders']/div/div[3]/div/button/div/div/div")).click();
    Thread.sleep(1000);
    driver.findElement(By.id("bs-select-1-3")).click();
    Thread.sleep(1000);

    driver.findElement(By.xpath("//button[@type='submit']")).click();
    Thread.sleep(2000);
  }

  @Test
  public void testINORDERFILTER04() throws Exception {
    driver.get(baseUrl + "admin/inhouse-orders");
    Thread.sleep(1000);

    driver.findElement(By.xpath("//form[@id='sort_orders']/div/div[3]/div/button/div/div/div")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//a[@id='bs-select-1-4']/span")).click();
    Thread.sleep(1000);

    driver.findElement(By.xpath("//button[@type='submit']")).click();
    Thread.sleep(2000);
  }

  @Test
  public void testINORDERFILTER05() throws Exception {
    driver.get(baseUrl + "admin/inhouse-orders");
    Thread.sleep(1000);

    driver.findElement(By.xpath("//form[@id='sort_orders']/div/div[3]/div/button/div/div/div")).click();
    Thread.sleep(1000);
    driver.findElement(By.id("bs-select-1-5")).click();
    Thread.sleep(1000);

    driver.findElement(By.xpath("//button[@type='submit']")).click();
    Thread.sleep(2000);
  }

  @Test
  public void testINORDERFILTER06() throws Exception {
    driver.get(baseUrl + "admin/inhouse-orders");
    Thread.sleep(1000);

    driver.findElement(By.xpath("//form[@id='sort_orders']/div/div[3]/div/button/div/div/div")).click();
    Thread.sleep(1000);
    driver.findElement(By.id("bs-select-1-6")).click();
    Thread.sleep(1000);

    driver.findElement(By.xpath("//button[@type='submit']")).click();
    Thread.sleep(2000);
  }

  @Test
  public void testINORDERFILTER07() throws Exception {
    driver.get(baseUrl + "admin/inhouse-orders");
    Thread.sleep(1000);

    driver.findElement(By.xpath("//form[@id='sort_orders']/div/div[4]/div/button/div/div/div")).click();
    Thread.sleep(1000);
    driver.findElement(By.id("bs-select-2-1")).click();
    Thread.sleep(1000);

    driver.findElement(By.xpath("//button[@type='submit']")).click();
    Thread.sleep(2000);
  }

  @Test
  public void testINORDERFILTER08() throws Exception {
    driver.get(baseUrl + "admin/inhouse-orders");
    Thread.sleep(1000);

    driver.findElement(By.xpath("//form[@id='sort_orders']/div/div[4]/div/button/div/div/div")).click();
    Thread.sleep(1000);
    driver.findElement(By.id("bs-select-2-2")).click();
    Thread.sleep(1000);

    driver.findElement(By.xpath("//button[@type='submit']")).click();
    Thread.sleep(2000);
  }

  @Test
  public void testINORDERFILTER09() throws Exception {
    driver.get(baseUrl + "admin/inhouse-orders");
    Thread.sleep(1000);

    driver.findElement(By.name("date")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Delete'])[1]/following::li[1]")).click();
    Thread.sleep(1000);

    driver.findElement(By.xpath("//button[@type='submit']")).click();
    Thread.sleep(2000);
  }

  @Test
  public void testINORDERFILTER10() throws Exception {
    driver.get(baseUrl + "admin/inhouse-orders");
    Thread.sleep(1000);

    driver.findElement(By.name("date")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Today'])[1]/following::li[1]")).click();
    Thread.sleep(1000);

    driver.findElement(By.xpath("//button[@type='submit']")).click();
    Thread.sleep(2000);
  }

  @Test
  public void testINORDERFILTER11() throws Exception {
    driver.get(baseUrl + "admin/inhouse-orders");
    Thread.sleep(1000);

    driver.findElement(By.name("date")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Yesterday'])[1]/following::li[1]")).click();
    Thread.sleep(1000);

    driver.findElement(By.xpath("//button[@type='submit']")).click();
    Thread.sleep(2000);
  }

  @Test
  public void testINORDERFILTER12() throws Exception {
    driver.get(baseUrl + "admin/inhouse-orders");
    Thread.sleep(1000);

    driver.findElement(By.name("date")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Last 7 Days'])[1]/following::li[1]")).click();
    Thread.sleep(1000);

    driver.findElement(By.xpath("//button[@type='submit']")).click();
    Thread.sleep(2000);
  }

  @Test
  public void testINORDERFILTER13() throws Exception {
    driver.get(baseUrl + "admin/inhouse-orders");
    Thread.sleep(1000);

    driver.findElement(By.xpath("//form[@id='sort_orders']/div/div[3]/div/button")).click();
    Thread.sleep(1000);
    driver.findElement(By.id("bs-select-1-1")).click();

    driver.findElement(By.xpath("//form[@id='sort_orders']/div/div[4]/div/button/div/div/div")).click();
    Thread.sleep(1000);
    driver.findElement(By.id("bs-select-2-2")).click();

    driver.findElement(By.name("date")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Yesterday'])[1]/following::li[1]")).click();

    driver.findElement(By.xpath("//button[@type='submit']")).click();
    Thread.sleep(2000);
  }

  @Test
  public void testINORDDELETE01() throws Exception {
    driver.get(baseUrl + "admin/inhouse-orders");
    Thread.sleep(1000);

    driver.findElement(By.xpath("//form[@id='sort_orders']/div[2]/table/tbody/tr/td[10]/a[3]/i")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//div[@id='delete-modal']/div/div/div[2]/button")).click();
    Thread.sleep(2000);
  }

  @Test
  public void testINORDDELETE02() throws Exception {
    driver.get(baseUrl + "admin/inhouse-orders");
    Thread.sleep(1000);

    driver.findElement(By.xpath("//form[@id='sort_orders']/div[2]/table/tbody/tr/td[10]/a[3]/i")).click();
    Thread.sleep(1000);
    driver.findElement(By.id("delete-link")).click();
    Thread.sleep(2000);
  }

  @Test
  public void testINORDDELETE03() throws Exception {
    driver.get(baseUrl + "admin/inhouse-orders");
    Thread.sleep(1000);

    driver.findElement(By.linkText("2")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//form[@id='sort_orders']/div[2]/table/tbody/tr/td/div/div/label/span")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//form[@id='sort_orders']/div[2]/table/tbody/tr[2]/td/div/div/label/span")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//form[@id='sort_orders']/div[2]/table/tbody/tr/td[10]/a[3]/i")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//div[@id='delete-modal']/div/div/div[2]/button")).click();
    Thread.sleep(2000);
  }

  @Test
  public void testINORDDELETE04() throws Exception {
    driver.get(baseUrl + "admin/inhouse-orders");
    Thread.sleep(1000);

    driver.findElement(By.linkText("2")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//form[@id='sort_orders']/div[2]/table/tbody/tr/td/div/div/label/span")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//form[@id='sort_orders']/div[2]/table/tbody/tr[2]/td/div/div/label/span")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//form[@id='sort_orders']/div[2]/table/tbody/tr/td[10]/a[3]")).click();
    Thread.sleep(1000);
    driver.findElement(By.id("delete-link")).click();
    Thread.sleep(2000);
  }

  @Test
  public void testINORDVIEW01() throws Exception {
    driver.get(baseUrl + "admin/inhouse-orders");
    Thread.sleep(1000);

    driver.findElement(By.xpath("//form[@id='sort_orders']/div[2]/table/tbody/tr/td[10]/a")).click();
    Thread.sleep(2000);
  }

  @Test
  public void testINORDDOWNLOAD01() throws Exception {
    driver.get(baseUrl + "admin/inhouse-orders");
    Thread.sleep(1000);

    driver.findElement(By.xpath("//form[@id='sort_orders']/div[2]/table/tbody/tr/td[10]/a[2]")).click();
    Thread.sleep(2000);
  }



  // --- HẬU ĐIỀU KIỆN (Chạy MỘT LẦN sau tất cả các @Test) ---
  @AfterClass
  public static void tearDown() throws Exception {
    if (driver != null) {
      driver.quit();
    }
  }

  // CÁC PHƯƠNG THỨC HỖ TRỢ
  private static boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  public static void main(String[] args) {
    Result result = JUnitCore.runClasses(_22130120_PhamQuocKhanh_Lab7.class);

    // Hiển thị kết quả
    for (Failure failure : result.getFailures()) {
      System.out.println(failure.toString());
    }

    System.out.println("Kiểm thử thành công: " + result.wasSuccessful());
  }
}