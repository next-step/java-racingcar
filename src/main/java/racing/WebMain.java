package racing;

import static spark.Spark.get;
import static spark.Spark.port;

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
    }

    private static void webServerConfigure() {
        port(8080);
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
