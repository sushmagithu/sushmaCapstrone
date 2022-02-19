package PageLaunchPack;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePack.BaseClass;

public class LoginVerifyTitle extends BaseClass {
	@FindBy(xpath = "//input[@name='uid']")
	WebElement usernamePath;

	@FindBy(xpath = "//input[@name='password']")
	WebElement pwdPath;

	@FindBy(xpath = "//input[@name='btnLogin']")
	WebElement submit_button;

	public LoginVerifyTitle() throws IOException {
		initialization();
		PageFactory.initElements(driver, this);
	}

	public void LoginVerify(String un, String pwd, String title,String manager)throws IOException, InterruptedException {
		usernamePath.sendKeys(un);
		pwdPath.sendKeys(pwd);
		submit_button.click();
		String Actualtitle= driver.getTitle();
		Assert.assertEquals(Actualtitle,title);

		String ActualLabel = driver.findElement(By.xpath(manager)).getText();
		Assert.assertEquals(ActualLabel, "Manger Id : mngr385718");

	}
}
