package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class testsignup {
    private WebDriver driver;

    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\Study\\DoAn\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    public void testSignup() {
        // Mở trang đăng ký
        driver.get("https://duck-king-milktea.onrender.com/auth/register");

        // Điền thông tin đăng ký
        WebElement nameInput = driver.findElement(By.name("full_name"));
        nameInput.sendKeys("User");
        
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("Vulinhnhi178@gmail.com");

        WebElement phoneNumberInput = driver.findElement(By.name("phone_number"));
        phoneNumberInput.sendKeys("0967878230");

        WebElement usernameInput = driver.findElement(By.name("username"));
        usernameInput.sendKeys("linhnhi1");
        
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("password123");

        WebElement confirmPasswordInput = driver.findElement(By.name("cfpassword"));
        confirmPasswordInput.sendKeys("password123");

        // Submit form đăng ký
        confirmPasswordInput.sendKeys(Keys.ENTER);

        // Kiểm tra xác nhận đăng ký thành công
        WebElement successMessage = driver.findElement(By.xpath("//div[contains(text(), 'Đăng ký thành công.')]"));
        assert successMessage.isDisplayed();
    }

    public void closeBrowser() {
        driver.quit();
        System.out.println("--Đóng--");
        System.out.println("-------Test script executed successfully----");
    }

    public static void main(String[] args) {
        testsignup test = new testsignup();
        test.setUp();
        test.testSignup();
        test.closeBrowser();
    }
}