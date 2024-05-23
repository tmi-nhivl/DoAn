package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ResetPassword {
	private WebDriver driver;
	public ResetPassword() {
		// Khởi tạo đường dẫn tới thư mục chứa ChromeDriver
		String driverPath = "D:\\Study\\DoAn\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		// Khởi tạo WebDriver
		driver = new ChromeDriver();
	}
	public void login (String username, String password) {
		driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1024, 768));
        driver.manage().deleteAllCookies();
        driver.get("https://duck-king-milktea.onrender.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        //chọn đến đăng nhập
        driver.findElement(By.xpath("//a[contains(text(),'ĐĂNG NHẬP')]")).click();
	}
	public void clickQMK() {
		//Tìm và nhấp vào liên kết quên mật khẩu
		WebElement forgotPasswordLink = driver.findElement(By.xpath("//a[contains(text(),'Quên mật khẩu?')]"));
		forgotPasswordLink.click();
	}
	public void inputEmail() {
		//Điền thông tin
		WebElement emailInput = driver.findElement(By.name("email"));
		emailInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		emailInput.sendKeys(Keys.BACK_SPACE);
		emailInput.sendKeys("vulinhnhi1782002@gmail.com");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void sendEmail() {
		//Gửi biểu mẫu
		WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(),'Tiếp tục')]"));
		submitButton.click();
	}
	public static void main(String[] args) {
		ResetPassword RSPS = new ResetPassword();
		RSPS.login("0967878230", "*Linhnhi178*");
		RSPS.clickQMK();
		RSPS.inputEmail();
		RSPS.sendEmail();
	}
}

