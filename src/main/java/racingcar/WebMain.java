package racingcar;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingGame;
import racingcar.domain.RacingGameResultSet;
import racingcar.template.TemplateEngine;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class WebMain {

    public static void main(String[] args) {
        port(8080);

        get("/", (req, res) -> TemplateEngine.render("/index.html"));

        post("/name", (req, res) -> {
            Map<String, Object> modelMap = new HashMap<>();
            modelMap.put("names", Arrays.asList(req.queryParams("names").split(" ")));

            return TemplateEngine.render(modelMap, "/game.html");
        });

        get("/result", (req, res) -> {
            int numberOfTimes = Integer.parseInt(req.queryParams("turn"));
            List<RacingCar> racingCars = RacingCar.create(Arrays.asList(req.queryParamsValues("name")));

            RacingGame racingGame = new RacingGame();
            List<RacingGameResultSet> racingGameResultSets = racingGame.startRace(numberOfTimes, racingCars);

            Map<String, Object> modelMap = new HashMap<>();
            modelMap.put("resultSets", racingGameResultSets);
            modelMap.put("winnerResultSets", racingGameResultSets.get(racingGameResultSets.size() - 1));

            return TemplateEngine.render(modelMap, "result.html");
        });
    }
}
