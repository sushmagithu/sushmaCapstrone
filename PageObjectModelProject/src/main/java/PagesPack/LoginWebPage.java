package PagesPack;

import java.io.IOException;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import BasePack.BaseClass;

public class LoginWebPage extends BaseClass {

	@FindBy(xpath = "/html/body/div[3]/div/ul/li[15]/a")
	WebElement logoutbutton;

	public LoginWebPage() throws IOException {
             PageFactory.initElements(driver, this);
	}

	public void login(String un, String pwd, String title) throws IOException, InterruptedException {
		String Actualtitle= driver.getTitle();
		Assert.assertEquals(Actualtitle,title);
		logoutbutton.click();
		Alert alert = driver.switchTo().alert();
		String alertmsg = alert.getText();
		Assert.assertEquals(alertmsg, "You Have Succesfully Logged Out!!");
		alert.accept();

	}
}
