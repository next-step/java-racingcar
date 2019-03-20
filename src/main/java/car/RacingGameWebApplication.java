package car;

import car.domain.GameResult;
import car.domain.RacingGame;
import car.view.ResultView;
import car.view.WebInputValue;
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
            String[] carNames = WebInputValue.getCarsName(test);

            model.put("names", carNames);
            return render(model, "/game.html");
        });

        get("/result", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int racingCount = WebInputValue.getRacingCount(req.queryParams("turn"));
            String[] carNames = WebInputValue.getCarsName(req.queryParams("names"));

            RacingGame racingGame = new RacingGame(carNames, racingCount);
            GameResult result = null;

            while ( racingGame.isRunning() ) {
                result = racingGame.playingGame();
            }
            model.put("result", result.getRoundResult());
            model.put("winners", result.getWinnerNames());
            List<String> str = result.getWinnerNames();

            return render(model, "/result.html");
        });
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
    /*
    public static void startGame() {
        RacingGame racingGame = new RacingGame(carsName, racingCount);
        GameResult result = null;

        while ( racingGame.isRunning() ) {
            result = racingGame.playingGame();
            ResultView.printGame(result);
        }

        ResultView.printGameWinner(result);
    }
    */
}
