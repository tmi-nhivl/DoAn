package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShoppingCartTest {
	private WebDriver driver;
	public ShoppingCartTest() {
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
		// chuyển đến trang sản phẩm
		WebElement productMenu = driver.findElement(By.xpath("//a[contains(text(),'SẢN PHẨM')]"));
		productMenu.click();
	}
	public void addProduct (int quantity) {
		// Thêm sản phẩm vào giỏ hàng
		for (int i = 0; i< quantity; i++) {
			//Thêm sản phẩm vào giỏ hàng
			WebElement addToCartButton = driver.findElement(By.xpath(""));
			addToCartButton.click();
			// Đợi một khoảng thời gian trước khi thêm sản phẩm tiếp theo 
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public void TangSanPham() {
		WebElement quantityInput = driver.findElement(By.xpath(""));
		quantityInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		quantityInput.sendKeys(Keys.BACK_SPACE);
		quantityInput.sendKeys("10");
		quantityInput.sendKeys(Keys.ENTER);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void GiamSanPham() {
		WebElement quantityInput = driver.findElement(By.xpath(""));
		quantityInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		quantityInput.sendKeys(Keys.BACK_SPACE);
		quantityInput.sendKeys("2");
		quantityInput.sendKeys(Keys.ENTER);
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
		ShoppingCartTest navigateToProductPage = new ShoppingCartTest();
		navigateToProductPage.login("adminaccount", "Adminaccount1");
		navigateToProductPage.ProductPage();
		navigateToProductPage.addProduct(2);
		navigateToProductPage.TangSanPham();
		navigateToProductPage.GiamSanPham();
		navigateToProductPage.tearDown();
	}
}
