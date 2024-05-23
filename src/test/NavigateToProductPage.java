package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateToProductPage {
	private WebDriver driver;
	public NavigateToProductPage() {
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
        driver.get("https://duck-king-milktea.onrender.com/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        //Nhập thông tin đăng nhập
        WebElement usernameInput = driver.findElement(By.name("username"));
        usernameInput.sendKeys(username);
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys(password);
        passwordInput.sendKeys(Keys.ENTER);
	}
	public void ProductPage() {
		//Chuyển đến trang sản phẩm
		WebElement productMenu = driver.findElement(By.xpath("//a[contains(text(),'SẢN PHẨM')]"));
		productMenu.click();
	}
	public void addProduct(int quantity) {
		//Thêm sản phẩm vào giỏ hàng
		for (int i = 0; i<quantity; i++) {
			WebElement addToCartButton = driver.findElement(By.xpath("//body/section[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]"));
			addToCartButton.click();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public void xoa1SP() {
		WebElement addToCartButton = driver.findElement(By.xpath("//body/section[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]"));
		addToCartButton.click();
	}
	public void xoaallSP() {
		WebElement addToCartButton = driver.findElement(By.xpath("//div[contains(text(),'Xóa tất cả')]"));
		addToCartButton.click();
		WebElement addToCartButton1 = driver.findElement(By.xpath("//button[contains(text(),'Xóa')]"));
		addToCartButton1.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void tearDown() {
        //driver.quit();
        System.out.println("--Đóng--");
        System.out.println("--Test script executed successfully-----");
    }
	public static void main(String[] args) {
		NavigateToProductPage navigateToProductPage = new NavigateToProductPage();
		navigateToProductPage.login("adminaccount", "Adminaccount1");
		navigateToProductPage.ProductPage();
		navigateToProductPage.addProduct(5);
		//xóa 1 sản phẩm
//		navigateToProductPage.xoa1SP();
		//xóa all sản phẩm
//		navigateToProductPage.xoaallSP();
		navigateToProductPage.tearDown();
	}
}
