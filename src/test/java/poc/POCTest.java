package poc;

import org.junit.Test;

public class POCTest {
	
	@Test
	public void simpleDriverTest(){
		System.setProperty("webdriver.chrome.driver", "C:/Users/pceqa/Documents/browserDrivers/chromedriver.exe");
		System.out.println(System.getProperty("webdriver.chrome.driver"));
	}

}
