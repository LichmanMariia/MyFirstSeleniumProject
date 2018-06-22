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

	private static WebDriver driver; // выносим за поле, что бы можно было использовать ее везде @BeforeClass, @Test, @AfterClass
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		driver = new ChromeDriver();
		System.setProperty("webdriver.chrom.driver", "chromedriver"); // (определ€ет где находитьс€ эмул€тор Chrome) ссылка на файл chromedriver, в корневой папке нашего проекта. webdriver.chrom.driver - общеприн€тое название  
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); // вызываем методы - определ€ем врем€ на ожидание отклика на сайте
		driver.manage().window().maximize(); // метод делает окно браузера на весь экран
		driver.get("https://www.ukr.net");  // метод отправит нас на страницу
		
	}

	
	@Test
	public void test() {
		
		WebElement form = driver.findElement(By.id("user-login-form")); // сужаем поиск по определенному кусочку программы по id (из кода на сайте)
		WebElement login = form.findElement(By.name("Login")); // используем тот контейнер "form", который мы ограничили
		login.sendKeys("alex06687");// вводит в это поле данную инфо
		WebElement password = form.findElement(By.name("Password")); 
		password.sendKeys("qwertyqwerty6565");
		WebElement button = form.findElement(By.tagName("button")); // прописываем нажатие на кнопку войти
		button.submit();
		
		WebElement register = driver.findElement(By.id("login-block")); //после входа на сайт, провер€ем авторизовались ли
		WebElement span = register.findElement(By.tagName("span"));
		String text = span.getText();
		assertEquals("alex06687@ukr.net", text);
		
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
		driver.quit();
		
	}
}
