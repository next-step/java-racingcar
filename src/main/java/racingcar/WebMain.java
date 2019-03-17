package racingcar;

import java.util.HashMap;
import racingcar.view.web.GameResult;
import racingcar.view.web.RacingGameService;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import java.util.Map;

import static spark.Spark.*;

public class WebMain {
    public static void main(String[] args) {
        port(8080);

        get("/", (req, res) -> render(null, "/index.html"));

        post("/name", (req, res) -> {

            String[] carNames = req.queryParams("names").split(" ");

            Map<String, Object> model = RacingGameService.getNames(carNames);

            return render(model, "/game.html");
        });

        post("/result", (req, res) -> {
            final String[] carNames = req.queryParamsValues("names");
            final int turn = Integer.parseInt(req.queryParams("turn"));

            Map<String, Object> model = new HashMap<>();

            GameResult gameResult = RacingGameService.startGame(carNames, turn);

            model.put("gameResult", gameResult);
            model.put("winnerNames", String.join(", ", gameResult.getWinnerNames()));

            return render(model, "/result.html");
        });
    }

    private static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
