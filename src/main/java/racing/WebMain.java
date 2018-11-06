package racing;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class WebMain {

    public static void main(String[] args) {
        
        webServerConfigure();
        
        routes();
    }

    private static void routes() {       
        get("/",  (req, res) -> {
            return render(null, "index.html");
        });
        
        post("/name", (req, res) -> {
            String names = req.queryParams("names");
            Map<String, Object> model = new HashMap<>();
            model.put("cars", names.split(" "));
            return render(model, "game.html");
        });

    }

    private static void webServerConfigure() {
        port(8080);
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
