package racingcar;

import racingcar.domain.Car;
import racingcar.view.OutputView;
import racingcar.domain.RacingGame;
import racingcar.view.RacingResult;
import racingcar.view.WinnerUtils;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class WebApp {

    private static String names;

    public static void main(String[] args) {
        port(8080);
        webStart();
    }

    private static void webStart() {

        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return render(null , "/index.html");
        });


        post("/name", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            names = req.queryParams("names");
            List<Car> cars = RacingGame.setupCar(names);
            model.put("cars", cars);
            return render(model, "/game.html");
        });

        post("/result", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            RacingGame racingGame = new RacingGame(names, Integer.parseInt(req.queryParams("turn")));
            RacingResult racingResult = null;
            while (racingGame.isEnd()) {
                racingResult = racingGame.startRace();

                OutputView.racingResultSave(racingResult);
                List<String> resultList = racingResult.getResultList();
                model.put("result", resultList);

                OutputView.consolePrintRacingResult(racingResult);

            }

            List<Car> winnersList = WinnerUtils.topRankSearch(racingResult);
            String winners = OutputView.getWinnerNames(winnersList);
            model.put("winners", winners);
            return render(model, "/result.html");
        });
    }


    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
