package jar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Sample page
 */
public class HomePage extends Page {

  @FindBy(how = How.CSS, using = "h1")
  public WebElement logo;

  public HomePage(WebDriver webDriver) {
    super(webDriver);
  }
}
