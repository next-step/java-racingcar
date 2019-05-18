package racing;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import static spark.Spark.*;

public class WebMain {
    public static void main(String[] args) {
        // root is 'src/main/resources', so put files in 'src/main/resources/public'
        staticFiles.location("/templates"); // Static files
        get("/", (req, res) -> {
            return render(null, "/index.html");
        });

        post("/name", (req, res) -> {
            String requestParam = req.queryParams("names");
            String [] cars = requestParam.split(" ");
            req.session().attribute("carNames", cars);

            List<String> racingCars = Arrays.asList(cars);
            Map<String, Object> model = new HashMap<>();
            model.put("cars", racingCars);

            return render(model, "/game.html");
        });

        get("/result", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("turn", Integer.parseInt(req.queryParams("turn")));
            int turn = Integer.parseInt(req.queryParams("turn"));
            String[] carNames = req.session().attribute("carNames");

            Racing racing = new Racing(carNames);

            for(int i = 0 ; i< turn ; i++){
                racing.onceMove();
            }

            model.put("results", racing.getRacingCar().getObjects());
            model.put("winners", racing.whoIsWin());

            return render(model, "/result.html");
        });
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
