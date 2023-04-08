package com.hrm.unittests;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.Test;

public class testdataprovider {
@Test
public void read()
{
	Properties pro = new Properties();
	try {
		pro.load(new FileInputStream(new File(
				System.getProperty("user.dir")+"\\configfiles\\testdata.properties")));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
		System.out.println(pro.get("browser"));
}
}
}