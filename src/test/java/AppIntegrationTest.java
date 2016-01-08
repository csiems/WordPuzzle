import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class AppIntegrationTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("The Coin Machine");
    //Tests that title of page displays (i.e. that page is loading.)
  }

  @Test public void testNameHere() {
    goTo("http://localhost:4567/");
    fill("#userInput").with("41");
    submit("#submit");
    assertThat(pageSource()).contains("1 penny");
    //Tests that if userInput field is filled with 41, the result contains
    //"1 penny".
  }

}
