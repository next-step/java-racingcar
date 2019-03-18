package racingcar.Application;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import racingcar.domain.RacingGame;
import racingcar.domain.RacingGameResult;
import racingcar.domain.RandomCreator;
import spark.ModelAndView;
import spark.Session;
import spark.template.handlebars.HandlebarsTemplateEngine;

import static  spark.Spark.*;
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
            Session session = req.session();
            session.attribute("names", inputNames);
            List<String> cars = Arrays.asList(inputNames.split(" "));
            model.put("cars", cars);
            return render(model, "game.html");
        });

        post("/result", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            Session session = req.session();
            String inputNames = session.attribute("names");
            String[] carNames = inputNames.split(" ");
            int round = Integer.parseInt(req.queryParams("turn"));

            RacingGame racingGame = new RacingGame(carNames, round);
            RacingGameResult racingGameResult = new RacingGameResult();

            while(!racingGame.isFinished()) {
                racingGame.playRound(new RandomCreator());
            }
            
            model.put("cars" , racingGame.sortCars());
            model.put("gameResult", racingGameResult.collectWinners(racingGame.sortCars()));
            return render(model, "result.html");
        });
    }

    private static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}