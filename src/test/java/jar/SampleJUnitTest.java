package jar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.support.PageFactory;

import jar.pages.HomePage;

public class SampleJUnitTest extends JUnitTestBase {

	private HomePage homepage;

	@Before
	public void initPageObjects() {
		homepage = PageFactory.initElements(driver, HomePage.class);
	}

	@Test
	public void testHomePageHasAHeader() {
		driver.get(baseUrl);
		Assert.assertTrue("Incorrect logo text.", "Welcome to the Internet".equals(homepage.logo.getText().trim()));
	}
}
