package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class usermanagement {
	private WebDriver driver;
	public usermanagement() {
		// Khởi tạo đường dẫn tới thư mục chứa ChromeDriver
		String driverPath = "D:\\Study\\DoAn\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        // Khởi tạo WebDriver
        driver = new ChromeDriver();
	}
	public void login(String username, String password) {
		driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1024, 768));
        driver.manage().deleteAllCookies();
        driver.get("https://duck-king-milktea.onrender.com/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        //Nhập thông tin đăng nhập
        WebElement usernameInput = driver.findElement(By.name("username"));
        usernameInput.sendKeys(username);
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys(password);
        passwordInput.sendKeys(Keys.ENTER);
	}
	public void CheckUser() {
		WebElement Check = driver.findElement(By.xpath("//div[contains(text(),'QUẢN LÝ')]"));
		Check.click();
		WebElement Check1 = driver.findElement(By.xpath("//div[contains(text(),'DANH SÁCH NGƯỜI DÙNG')]"));
		Check1.click();
	}
	public void DeleteUser() {
		//xóa
		WebElement tableElement = driver.findElement(By.xpath("//tbody/tr[@id='663e3f56b43389e2d9600234']/td[6]/i[2]"));
		tableElement.click();
		WebElement buttonElement = driver.findElement(By.xpath("//button[contains(text(),'Xóa')]"));
		buttonElement.click();
		
	}
	//Xem đơn hàng
	public void ViewOrders() {
		WebElement buttonElement1 = driver.findElement(By.xpath("//tbody/tr[@id='663e312fc1c829cbc1f3ee48']/td[7]/a[1]"));
		buttonElement1.click();
	}
	//sửa
	public void FixUser() {
		// WebElement tableElement = driver.findElement(By.id("user_test"));
		// WebElement tdElement = tableElement.findElement(By.id("sua_test"));
		// tdElement.click();
		WebElement tableElement = driver.findElement(By.xpath("//tbody/tr[@id='663e312fc1c829cbc1f3ee48']/td[6]/i[1]"));
		tableElement.click();
	}
	public void tearDown() {
        //driver.quit();
        System.out.println("--Đóng--");
        System.out.println("--Test script executed successfully-----");
    }
	public static void main(String[] args) {
        usermanagement usermanagementTest = new usermanagement();
        usermanagementTest.login("adminaccount", "Adminaccount1");
        usermanagementTest.CheckUser();
//        usermanagementTest.DeleteUser();
//        usermanagementTest.ViewOrders();
        usermanagementTest.FixUser();
        usermanagementTest.tearDown();
    }

}
