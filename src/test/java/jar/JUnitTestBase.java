package jar;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.rules.ExternalResource;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Capabilities;

import ru.stqa.selenium.factory.WebDriverFactory;

import jar.util.PropertyLoader;

/**
 * Base class for all the JUnit-based test classes
 */
public class JUnitTestBase {

	protected static String gridHubUrl;
	protected static String baseUrl;
	protected static Capabilities capabilities;

	protected WebDriver driver;

	@ClassRule
	public static ExternalResource webDriverProperties = new ExternalResource() {
		@Override
		protected void before() throws Throwable {
			baseUrl = PropertyLoader.loadProperty("site.url");
			gridHubUrl = PropertyLoader.loadProperty("grid2.hub");
			baseUrl = PropertyLoader.loadProperty("site.url");
			gridHubUrl = PropertyLoader.loadProperty("grid.url");
			if ("".equals(gridHubUrl)) {
				gridHubUrl = null;
			}
			capabilities = PropertyLoader.loadCapabilities();
		};
	};

	@Rule
	public ExternalResource webDriver = new ExternalResource() {
		@Override
		protected void before() throws Throwable {
			String browserDriversPath = Paths.get(System.getProperty("user.dir"), "src/test/resources/browserDrivers").toString();
			String chromeDriverPath = Paths.get(browserDriversPath, "chromedriver.exe").toString();
			String edgeDriverPath = Paths.get(browserDriversPath, "MicrosoftWebDriver.exe").toString();
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			System.setProperty("webdriver.edge.driver", edgeDriverPath);

			driver = WebDriverFactory.getDriver(gridHubUrl, capabilities);
		};
	};
}
