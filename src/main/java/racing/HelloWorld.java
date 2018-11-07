package racing;

import racing.domain.Car;
import racing.domain.RacingGame;
import racing.view.ResultView;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class HelloWorld {
    public static void main(String[] args) {
        port(8080);
        staticFiles.location("/templates");
        get("/helloworld", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String name = req.queryParams("name");
            model.put("name", name);
            return render(model, "/helloworld.html");
        });

        get("/hello/:name", (request, response) -> {
            return "Hello: " + request.params(":name");
        });

        post("/name", (req,res) -> {
            Map<String, Object> model = new HashMap<>();
            String names = req.queryParams("names");
            String[] namesSpliit = names.split(" ");
            model.put("names", namesSpliit);
            return render(model, "/game.html");
        });
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
