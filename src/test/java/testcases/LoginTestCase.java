package testcases;

import java.io.IOException;
import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjectModel.loginPageObject;


import Resources.BaseClass;
import Resources.Constants;
import Resources.commonMethods;

public class LoginTestCase extends BaseClass {

	@Test (dataProvider="testData")
	public void verifyLogin(String username, String password ) throws IOException {
		
		loginPageObject lpo= new loginPageObject (driver);
		
		lpo.enterUsername().sendKeys(username);
		lpo.enterPassword().sendKeys(password);
		lpo.clickOnLogin().click();
		
		/*WebElement a= lpo.errorMessage();
		String actualText= a.getText();*/
		
		
		commonMethods.verifyAssertions(lpo.errorMessage(), Constants.expectedTextErrorMSg, "Valid Error message is not showing");
		 
	}
	//object is class--  
	//Object[][]-  is return type of dataprovider
	@DataProvider
	public Object[][] testData() {   //testData() - is dataprovider name
	  Object[][] data=new Object[3][2]; //create the object of object class
	  data[0][0]=Constants.username1; //1st username
	  data[0][1]=Constants.password1;// 1st password
	  data[1][0]=Constants.username2; //2nd username
	  data[1][1]=Constants.password2; //2nd password
	  data[2][0]=Constants.username3; //3rd username
	  data[2][1]=Constants.password3;  //3rd password
	 
	  return data;
	 
	}
	
}
