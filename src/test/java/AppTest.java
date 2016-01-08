import org.junit.*;
import static org.junit.Assert.*;

public class AppTest {

  @Test
  public void replaceTheVowels_ReplacesAWithDash_Dash() {
    App appTest = new App();
    assertEquals("-", appTest.replaceTheVowels("a"));
  }

  @Test
  public void replaceTheVowels_ReplacesAllVowelsWithDash_FiveDashes() {
    App appTest = new App();
    assertEquals("-----", appTest.replaceTheVowels("aeiou"));
  }

  @Test
  public void replaceTheVowels_ReplacesAllCapitalVowelsWithDash_FiveDashes() {
    App appTest = new App();
    assertEquals("-----", appTest.replaceTheVowels("AEIOU"));
  }

  @Test
  public void replaceTheVowels_ReplacesVowelsWithDashButLeavesConsonantsAlone_CDasht() {
    App appTest = new App();
    assertEquals("C-t", appTest.replaceTheVowels("Cat"));
  }

}
