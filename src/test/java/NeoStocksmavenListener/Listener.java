package NeoStocksmavenListener;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Listeners;



import PomClass.UtilityNew;
@Listeners(NeoStocksmavenListener.Listener.class)
public class Listener extends BaseClass.NewBase  implements ITestListener

{

	public void onTestSuccess(ITestResult result) 
	{
		String passMethod = result.getName();
		Reporter.log("TC"+passMethod+" is completed successfuly",true);
	}
	
	public void onTestSkipped(ITestResult result) 
	{
		
		Reporter.log("TC"+result.getName()+" is Skip",true);
	}
	
	public void onTestFailure(ITestResult result) 
	{
		Reporter.log("TC"+result.getName()+" is Failed",true);
		try {
			UtilityNew.takeSceenshot(driver, result.getName());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
}
