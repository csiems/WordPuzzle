import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;


public class App{
  public static void main(String[] args){
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/output", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/output.vtl");

      String userInput = request.queryParams("userInput");
      String dashedLine = replaceTheVowels(userInput);

      model.put("userInput", userInput);
      model.put("dashedLine", dashedLine);

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }

    public static String replaceTheVowels(String userInput) {
      String[] vowels = {"A", "E", "I", "O", "U", "a", "e", "i", "o", "u"};
      String dashedLine = "";

      for( Integer i = 0; i < userInput.length(); i++) {
        char[] inputAsCharArray = userInput.toCharArray();
        char individualChar = inputAsCharArray[i];
        String convertedChar = Character.toString(individualChar);
        Integer isItAVowel = Arrays.asList(vowels).indexOf(convertedChar);
        if( isItAVowel >=0 ) {
          dashedLine += "-";
        } else {
          dashedLine += convertedChar;
        }
      }
      return dashedLine;
    }

}
