import java.util.Random;
import java.io.Console;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App{
  public static void main(String[] args){
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap();

      model.put("template", "templates/form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap();
      //Declare your variables that will be used.
      String user1Input = request.queryParams("user1Input");
      String user2Input = computerChooses();
      String winner = checkWinner(user1Input, user2Input);
      //Put variables into HashMap; the first string is what is used in your forms
      //with a $ in front of it; the second string is the variable it is matched to.
      model.put("user1Input", user1Input);
      model.put("user2Input", user2Input);
      model.put("winner", winner);
      model.put("template", "templates/output.vtl");

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }

    public static String firstMethod(String variableItTakes) {
       //Functions will go here.
    }

}
