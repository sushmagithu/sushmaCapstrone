package PageObjectTestcases;

import java.io.IOException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import BasePack.BaseClass;
import PagesPack.LoginWebPage;

public class TC_002_Login extends BaseClass {
	public LoginWebPage lp;
	
	public TC_002_Login() throws IOException {
		super();
	}
	
	@BeforeMethod 
	public void SetUp() throws IOException, InterruptedException {
	     lp=new LoginWebPage();	
	}
	@Test
	public void validateLogin() throws IOException, InterruptedException
	{
		lp.login(prop.getProperty("username"), prop.getProperty("password"),prop.getProperty("pagetitle"));
	
	}
	
}
