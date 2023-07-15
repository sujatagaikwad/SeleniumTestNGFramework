package testcases;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import Resources.BaseClass;
import Resources.Constants;
import Resources.commonMethods;
import pageObjectModel.loginPageObject;
import pageObjectModel.SignupPageObjects;
import org.openqa.selenium.support.ui.Select;


public class SignupTestCases extends BaseClass {

	@Test
	public void verifySignup() throws IOException, InterruptedException {

	
		 
		  loginPageObject lpo=new loginPageObject (driver);
		  lpo.clickOntryForFree().click();
		 
		 
		  SignupPageObjects spo=new SignupPageObjects(driver);
		 
		 
		  Thread.sleep(5000);
		  spo.enterFirstName().sendKeys(Constants.firstName);
		  
		  spo.enterLastName().sendKeys(Constants.lastName);
		 
		  spo.enterJobTitle().sendKeys(Constants.jobTitle);
		 
		  spo.clickOnNextButton().click();
		 
		  commonMethods.selectDropdown(spo.selectEmployees(), 2); //employee dropdown
		 
		  spo.enterCompanyName().sendKeys("test");
		  commonMethods.selectDropdown(spo.selectCountry(), 3);
		//commonMethods.selectDropdownWithVisbleTExt(spo.selectCountry(), "India");
		  spo.clickOnNextButton().click();
		 
		 commonMethods.verifyAssertions(spo.signupPageConfirmation(), Constants.expectedTextSignupText, "Valid signup text is not showing");
		 

		 
		 
		 
		}


}

