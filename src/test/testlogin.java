package test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class testlogin {
	private WebDriver driver;

    public void Login() {
        // Khởi tạo đường dẫn tới thư mục chứa ChromeDriver
        String driverPath = "D:\\Study\\DoAn\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        // Khởi tạo WebDriver
        driver = new ChromeDriver();
    }

    public void login(String username, String password) {
        // load web mất 3~5s
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1024, 768));
        driver.manage().deleteAllCookies();
        driver.get("https://duck-king-milktea.onrender.com/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        // Nhập thông tin đăng nhập
        WebElement usernameInput = driver.findElement(By.name("username"));
        usernameInput.sendKeys(username);
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys(password);
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        passwordInput.sendKeys(Keys.ENTER);
    }

    // đóng trình duyệt
    public void tearDown() {
        driver.quit();
        System.out.println("--Đóng--");
        System.out.println("--Test script executed successfully-----");
    }

    public static void main(String[] args) {
        testlogin lg = new testlogin();
        lg.Login();
        lg.login("0967878230", "*Linhnhi178*");
        lg.tearDown();
    }
}