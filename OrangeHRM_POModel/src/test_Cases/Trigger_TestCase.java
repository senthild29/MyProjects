package test_Cases;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

public class Trigger_TestCase {

	public static void main(String[] args) {
	
		TestNG testNGTestCase = new TestNG();
		
		List<String> suites = new ArrayList<String>();
		
		suites.add("F:\\Senthil\\Testing\\Selenium Workspace\\OrangeHRM_POModel\\TestNG_Suite.xml");
		testNGTestCase.setTestSuites(suites);
		testNGTestCase.run();

	}

}
