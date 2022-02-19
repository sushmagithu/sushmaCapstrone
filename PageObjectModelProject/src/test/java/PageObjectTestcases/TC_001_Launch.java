package PageObjectTestcases;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BasePack.BaseClass;
import PageLaunchPack.LoginVerifyTitle;
import PagesPack.LoginWebPage;

public class TC_001_Launch extends BaseClass {
	
	public LoginVerifyTitle lv;
	
	public TC_001_Launch() throws IOException {
		super();
		
	}
	@BeforeMethod 
	public void SetUpLaunch() throws IOException, InterruptedException {
	     lv=new LoginVerifyTitle();	
	}
	@Test
	public void validateTitle() throws IOException, InterruptedException
	{
		lv.LoginVerify(prop.getProperty("username"), prop.getProperty("password"),prop.getProperty("pagetitle"),prop.getProperty("managerid"));
	
	}
	
}



