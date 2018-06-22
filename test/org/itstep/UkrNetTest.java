package org.itstep;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UkrNetTest {

	private static WebDriver driver; // ������� �� ����, ��� �� ����� ���� ������������ �� ����� @BeforeClass, @Test, @AfterClass
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		driver = new ChromeDriver();
		System.setProperty("webdriver.chrom.driver", "chromedriver"); // (���������� ��� ���������� �������� Chrome) ������ �� ���� chromedriver, � �������� ����� ������ �������. webdriver.chrom.driver - ������������ ��������  
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); // �������� ������ - ���������� ����� �� �������� ������� �� �����
		driver.manage().window().maximize(); // ����� ������ ���� �������� �� ���� �����
		driver.get("https://www.ukr.net");  // ����� �������� ��� �� ��������
		
	}

	
	@Test
	public void test() {
		
		WebElement form = driver.findElement(By.id("user-login-form")); // ������ ����� �� ������������� ������� ��������� �� id (�� ���� �� �����)
		WebElement login = form.findElement(By.name("Login")); // ���������� ��� ��������� "form", ������� �� ����������
		login.sendKeys("alex06687");// ������ � ��� ���� ������ ����
		WebElement password = form.findElement(By.name("Password")); 
		password.sendKeys("qwertyqwerty6565");
		WebElement button = form.findElement(By.tagName("button")); // ����������� ������� �� ������ �����
		button.submit();
		
		WebElement register = driver.findElement(By.id("login-block")); //����� ����� �� ����, ��������� �������������� ��
		WebElement span = register.findElement(By.tagName("span"));
		String text = span.getText();
		assertEquals("alex06687@ukr.net", text);
		
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
		driver.quit();
		
	}
}
