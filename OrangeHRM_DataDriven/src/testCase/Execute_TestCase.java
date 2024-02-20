package testCase;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

public class Execute_TestCase {

	
	  public static void main(String[] args) {
	  
	  TestNG testNG = new TestNG();
	  
	  List<String> testsuites = new ArrayList<String>();
	  
	  testsuites.add("C:\\Users\\Senthil\\git\\MavenRepo\\IntroToMaven\\TestNG_Suite.xml");
	 
	  testNG.setTestSuites(testsuites); testNG.run();
	  
	  }
	 

}
