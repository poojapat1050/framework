package com.hrm.TestCases;

import org.testng.annotations.Test;

import com.hrm.Pages.login;
import com.hrm.factories.Baseclass;

public class Logindemo_pagefactory extends Baseclass  {
@Test
public void logintest()
{
	logger=Reports.createTest("login test");
	login l_p= new login(driver);
	l_p.enteruserName();
	l_p.enterpassword();
	l_p.submit();
}
}
