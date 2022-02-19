package EditPack;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import BasePack.BaseClass;
import PagesPack.HomeWebPage;

public class EditCustomer extends BaseClass {


	@FindBy(xpath = "/html/body/div[3]/div/ul/li[3]/a")
	WebElement editButton;

	@FindBy(xpath = "//input[@name='cusid']")
	WebElement searchExistingId;

	@FindBy(xpath = "//input[@name='AccSubmit']")
	WebElement submitButton;

	public EditCustomer() throws IOException {
		
		PageFactory.initElements(driver, this);
	}

	public void EditOperation(String cid) throws IOException {

		editButton.click();
		searchExistingId.click();
		searchExistingId.sendKeys(cid);
		submitButton.click();
		Alert alert = driver.switchTo().alert();
		String alertmsg = alert.getText();
		Assert.assertEquals(alertmsg, "You are not authorize to edit this customer!!");
		alert.accept();

	}

}
