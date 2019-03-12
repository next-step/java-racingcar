package spark;

import racing.view.RacingCarView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class Application {
    public static void main(String[] args) {
        staticFileLocation("templates");

        get("/", (req, res) -> "index.html");
        post("/name", (req, res) -> {

            String params = req.queryParams("names");
            String[] names = RacingCarView.parseCarNames(params);

            Map<String, Object> model = new HashMap<>();
            model.put("names", names);

            return render(model, "game.html");
        });
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
