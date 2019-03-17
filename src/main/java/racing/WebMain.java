package racing;

import racing.service.RacingGameService;
import racing.view.RacingGameRequestView;
import racing.view.RacingGameResultView;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class WebMain {
    public static void main(String[] args) {
        port(8080);

        get("/", (req, res) -> render(null, "/index.html"));

        post("/name", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String[] carNames = req.queryParams("names").split(" ");

            RacingGameRequestView view = new RacingGameRequestView(carNames);
            model.put("names", view.getCarNames());
            return render(model, "/game.html");
        });

        get("/result", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            int turn = Integer.parseInt(req.queryParams("turn"));
            String[] carNames = req.queryParamsValues("names");
            RacingGameRequestView request = new RacingGameRequestView(carNames, turn);

            RacingGameResultView result = RacingGameService.run(request);
            model.put("result", result);
            return render(model, "/result.html");
        });
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
