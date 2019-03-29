package car;

import car.domain.GameResult;
import car.domain.RacingGame;
import car.domain.SavedRacingCar;
import car.view.ResultView;
import car.view.WebInputValue;
import car.view.WebResultView;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class RacingGameWebApplication {


    public static void main(String args[]) {
        port(8080);

        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return render(model, "/index.html");
        });

        post("/name", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String test  = req.queryParams("names");
            SavedRacingCar.racingCars = WebInputValue.getCarsName(test);

            model.put("names", SavedRacingCar.racingCars);
            return render(model, "/game.html");
        });

        post("/result", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int racingCount = WebInputValue.getRacingCount(req.queryParams("turn"));
            RacingGame racingGame = new RacingGame(SavedRacingCar.racingCars, racingCount);
            GameResult result = null;

            while ( racingGame.isRunning() ) {
                result = racingGame.playingGame();
            }
            model.put("result", result.getRoundResult());
            model.put("winners", WebResultView.printGameWinner(result));

            return render(model, "/result.html");
        });
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
