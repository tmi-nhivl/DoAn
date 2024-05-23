package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProductManagementTest {
	private WebDriver driver;
	public ProductManagementTest() {
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
	public void CheckProduct() {
		WebElement Check = driver.findElement(By.xpath("//div[contains(text(),'QUẢN LÝ')]"));
		Check.click();
		WebElement Check1 = driver.findElement(By.xpath("//div[contains(text(),'DANH SÁCH SẢN PHẨM')]"));
		Check1.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void MoreProduct() {
		WebElement linkELement = driver.findElement(By.cssSelector("a[href='/products/create/admin']"));
		linkELement.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//chọn ảnh
//		WebElement divElement = driver.findElement(By.xpath("//body/div[4]/a[1]/button[1]"));
		WebElement inputElement = driver.findElement(By.xpath("//input[@id='formFileSm']"));
		inputElement.sendKeys("D:\\Study\\ThucTapCSN\\Nhi\\images\\images hehe\\choco-creamcake.png");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//Nhập tên
		WebElement nameInput = driver.findElement(By.name("name"));
		nameInput.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		nameInput.sendKeys(Keys.BACK_SPACE);
		nameInput.sendKeys("Trà sữa choco");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//nhập giá
		WebElement priceInput = driver.findElement(By.name("price"));
		priceInput.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		priceInput.sendKeys(Keys.BACK_SPACE);
		priceInput.sendKeys("35000");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//Nhập thể loại
		WebElement categoryInput = driver.findElement(By.name("category"));
		categoryInput.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		categoryInput.sendKeys(Keys.BACK_SPACE);
		categoryInput.sendKeys("Trà sữa");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//Nhập mô tả
		WebElement descriptionInput = driver.findElement(By.name("description"));
		descriptionInput.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		descriptionInput.sendKeys(Keys.BACK_SPACE);
		descriptionInput.sendKeys("Thơm ngon");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//Tạo
		WebElement buttonElement = driver.findElement(By.xpath("//button[contains(text(),'Tạo')]"));
		buttonElement.click();
		WebElement buttonElement1 = driver.findElement(By.xpath("//button[contains(text(),'OK')]"));
		buttonElement1.click();
		nameInput.sendKeys(Keys.BACK_SPACE);
		nameInput.sendKeys("Trà sữa");
		try {
			Thread.sleep(1000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void functionProduct() {
		WebElement Check = driver.findElement(By.xpath("//a[contains(text(),'SẢN PHẨM')]"));
		Check.click();
		WebElement CheckProduct = driver.findElement(By.xpath(""));
		CheckProduct.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement tableElement = driver.findElement(By.xpath(""));
		tableElement.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement buttonElement = driver.findElement(By.id("tao_test"));
		buttonElement.click();
	}
	public static void main(String[] args) {
		ProductManagementTest ProductManagementTest = new ProductManagementTest();
		ProductManagementTest.login("adminaccount", "Adminaccount1");
		ProductManagementTest.CheckProduct();
		ProductManagementTest.MoreProduct();
		ProductManagementTest.functionProduct();
	}
	
}
