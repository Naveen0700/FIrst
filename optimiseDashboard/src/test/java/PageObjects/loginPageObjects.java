package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPageObjects {

	WebDriver driver;

	// Web elements in the page
	By logo = By.className("img-responsive");
	By userName = By.id("officerId");
	By passWord = By.id("password");
	By loginButton = By.id("btnLogin");

	// Constructor that will be automatically called as soon as the object of the class is created
	public loginPageObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	//Logo method
	public boolean logo() {
		return driver.findElement(logo).isDisplayed();
	}

	// Username method
	public void userName(String user){
		driver.findElement(userName).sendKeys(user);
	}

	// Password method
	public void passWord(String pass){
		driver.findElement(passWord).sendKeys(pass);
	}

	// Click Login button method
	public void buttonClick(){
		driver.findElement(loginButton).click();
	}
}

