package racingcar.view;

import racingcar.domain.GameResult;
import racingcar.domain.RacingGame;
import racingcar.util.CustomTemplateEngine;
import spark.ModelAndView;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class WebMain {
    public static void main(String[] args) {
        port(8080);

        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return render(model, "/index.html");
        });

        post("/name", (req, res) -> {
            String name = req.queryParams("names");
            RacingGame game = new RacingGame(name);
            req.session().attribute("game", game);

            Map<String, Object> model = new HashMap<>();
            model.put("cars", game.getCars());
            return render(model, "/game.html");
        });

        post("/result", (req, res) -> {
            String turn = req.queryParams("turn");
            RacingGame game = req.session().attribute("game");
            GameResult gameResult = game.play(Integer.parseInt(turn));

            Map<String, Object> model = new HashMap<>();
            model.put("cars", gameResult.getLastRound().getCars());
            model.put("winners", gameResult.getWinners().getWinnersName());
            return render(model, "/result.html");
        });
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new CustomTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
