package PageObjectTestcases;

import java.io.IOException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import BasePack.BaseClass;
import DeletePack.DeleteCustomer;

public class TC_003_Delete extends BaseClass {
	public DeleteCustomer dc;

	public TC_003_Delete() throws IOException {
		super();

	}

	@BeforeMethod
	public void SSetUp() throws IOException, InterruptedException {
		dc = new DeleteCustomer();
	}

	@Test
	public void validateDelete() throws IOException {
		dc.deleteOperation(prop.getProperty("username"), prop.getProperty("password"), prop.getProperty("invalidId"));

	}
}
