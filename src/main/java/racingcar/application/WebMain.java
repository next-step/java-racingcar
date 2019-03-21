package racingcar.application;

import racingcar.domain.RacingGame;
import racingcar.domain.RacingGameResult;
import racingcar.domain.RandomCreator;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;
public class WebMain {
    public static void main(String[] args) {
        port(8080);

        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return render(model, "index.html");
        });

        post("/name", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String inputNames = req.queryParams("names");
            List<String> cars = Arrays.asList(inputNames.split(" "));
            model.put("cars", cars);
            return render(model, "game.html");
        });

        post("/result", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int inputRound = Integer.parseInt(req.queryParams("turn"));
            String[] carNames = req.queryParams("names").split(" ");

            RacingGame racingGame = new RacingGame(carNames, inputRound);
            RacingGameResult racingGameResult = new RacingGameResult();

            for(int round = 0; round < racingGame.getTime(); round++) {
                racingGame.playRound(new RandomCreator());
            }

            model.put("cars" , racingGame.getCars());
            model.put("gameResult", racingGameResult.collectWinners(racingGame.getCars()));
            return render(model, "result.html");
        });
    }

    private static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}