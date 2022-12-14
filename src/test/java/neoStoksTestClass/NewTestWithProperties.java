package neoStoksTestClass;


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import PomClass.NeoStoxHomePage;
import PomClass.NeoStoxPassWordPage;
import PomClass.NeoStoxSignLogin;
import PomClass.UtilityNew;



public class NewTestWithProperties extends BaseClass.NewBase
{
	NeoStoxSignLogin login;
	NeoStoxPassWordPage password;
	NeoStoxHomePage home;
	
	@BeforeClass
	public void launchNeoStox() throws IOException
	{
		launchBrowser();
	login= new  NeoStoxSignLogin(driver);
	password= new NeoStoxPassWordPage(driver);
	home= new NeoStoxHomePage(driver);
	}
	@BeforeMethod
	public void loginToNeoStox() throws EncryptedDocumentException, 
	IOException, InterruptedException
	{
	login.sendMobileNum(driver, UtilityNew.readDataFromProprtyFile("MobileNumber"));
	login.clickOnSignInButton(driver);
	Thread.sleep(1000);
	password.sendPassword(driver, UtilityNew.readDataFromProprtyFile("Password"));
	password.clickOnSubmitButton(driver);
	Thread.sleep(1000);
	home.popUpHandle(driver);
	}
	@Test
	 public void validateUserName() throws EncryptedDocumentException, IOException
	{
	Assert.assertNotNull(home.getBalance(driver) );
	Reporter.log("AC balance is "+home.getBalance(driver), true);

	UtilityNew.takeSceenshot(driver, home.getUserName());
	
	 }
	@AfterMethod
	public void logout()
	{
	home.logoutFormNeoStox(driver);
	}
	@AfterClass
	public void closeApplication() throws InterruptedException
	{
	closingBrowser(driver);
	}
	}


