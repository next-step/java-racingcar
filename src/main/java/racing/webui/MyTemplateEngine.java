package racing.webui;

import static spark.Spark.*;

import java.util.HashMap;
import java.util.Map;

import racing.component.RacingGame;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class MyTemplateEngine {
    public static void main(String[] args) {
        staticFiles.location("/templates");
        port(8080);

        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("name", "2cycle");
            return render(model, "/index.html");
        });

        post("/name", (req, res) -> {
            String carNames = req.queryParams("names");
            RacingGame rg = new RacingGame(carNames.split(" "));
            req.session().attribute("carNames" ,carNames);

            Map<String, Object> model = new HashMap<>();
            model.put("cars", rg.getCars());
            return render(model, "/game.html");
        });


        get("/result", (req, res) -> {
            String carNames = req.session().attribute("carNames");
            RacingGame rg = new RacingGame(carNames.split(" "));
            Map<String, Object> model = new HashMap<>();

            int times = Integer.parseInt(req.queryParams("turn"));
            for (int i = 0; i < times; i++) {
                rg.startGame();
            }
            model.put("cars", rg.getCars());

            String winners = String.join(",",rg.racingWinnersString(rg.getCars()));
            model.put("winners",winners);
            return render(model, "/result.html");
        });


    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}