package racingcar.view;

import racingcar.CustomHandlebarsTemplateEngine;
import racingcar.RacingGame;
import racingcar.RacingResult;
import racingcar.domain.Car;
import spark.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class WebMain {

    public static void main(String[] args) {

        port(8080);
        staticFiles.location("/templates");

        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return render(model, "index.html");
        });

        post("/name", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String[] names = req.queryParams("names").split(" ");
            model.put("names", names);
            return render(model, "game.html");
        });

        get("/result", (req, res) -> {
            String[] names = req.queryParamsValues("names");
            int turn = Integer.parseInt(req.queryParams("turn"));
            RacingGame racingGame = new RacingGame();
            racingGame.readyCars(String.join(",", names));

            for (int i=0; i<turn; i++) {
                racingGame.startRacing();
            }

            RacingResult racingResult = new RacingResult(racingGame.getCars());
            String winners = racingResult.getWinners();
            List<Car> cars = racingGame.getCars();
            Map<String, Object> model = new HashMap<>();
            model.put("cars", cars);
            model.put("winners", winners);
            return render(model, "result.html");
        });
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new CustomHandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
