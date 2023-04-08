package com.hrm.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.hrm.Pages.login;
import com.hrm.factories.Baseclass;

public class Logindemo extends Baseclass  {
@Test
public void logintest()
{
	logger=Reports.createTest("login test");
	//login l_p= new login(driver);
	login loginp=PageFactory.initElements(driver, login.class);
	loginp.enteruserName();
	loginp.enterpassword();
	loginp.submit();
}
}
