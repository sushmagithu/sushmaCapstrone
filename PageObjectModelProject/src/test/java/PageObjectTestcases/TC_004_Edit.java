package PageObjectTestcases;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import BasePack.BaseClass;
import EditPack.EditCustomer;

public class TC_004_Edit extends BaseClass {
	public EditCustomer ec;
	public TC_004_Edit() throws IOException {
		super();
		
	}
	
	@BeforeMethod
	public void deleteSetUp() throws IOException, InterruptedException {
		ec = new EditCustomer();
	}

	@Test
	public void validateEdit() throws IOException {
		ec.EditOperation(prop.getProperty("validId"));

	}
	@AfterSuite
	public void afterSuite() {
	driver.close();
	}
}


