package racingGame;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.Collections;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.port;

public class WebMain {

    public static void main(String[] args) {
        port(8080);

        get("/", (request, response) -> render(Collections.emptyMap(), "index.html"));
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
