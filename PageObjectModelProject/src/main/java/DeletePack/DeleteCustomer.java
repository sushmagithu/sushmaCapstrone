package DeletePack;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import BasePack.BaseClass;

public class DeleteCustomer extends BaseClass {
	@FindBy(xpath = "//input[@name='uid']")
	WebElement usernameBox;

	@FindBy(xpath = "//input[@name='password']")
	WebElement pwdBox;

	@FindBy(xpath = "//input[@name='btnLogin']")
	WebElement submit_button;
	
	@FindBy(xpath = "/html/body/div[3]/div/ul/li[4]/a")
	WebElement deletelink;
	
	@FindBy(xpath = "//input[@name='cusid']")
	WebElement customerFeild;
	
	public DeleteCustomer() throws IOException {
		
		PageFactory.initElements(driver, this);
	}
	
	public void deleteOperation(String un,String pwd,String cid) throws IOException {

		usernameBox.sendKeys(un);
		pwdBox.sendKeys(pwd);
		submit_button.click();
		deletelink.click();
		customerFeild.click();
		customerFeild.sendKeys(cid);
		customerFeild.sendKeys(Keys.chord(Keys.ENTER));
		Alert deleteAlert=driver.switchTo().alert();
		deleteAlert.accept();
		
		Alert dAlert=driver.switchTo().alert();
		String alertmsg=dAlert.getText();
        Assert.assertEquals(alertmsg, "Customer does not exist!!");
        dAlert.accept();
		

}
}
