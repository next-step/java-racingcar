package game.racing;

import game.racing.domain.Car;
import game.racing.domain.CarFactory;
import game.racing.domain.GameResult;
import game.racing.domain.RacingGame;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

public class WebMain {

    public static void main(String[] args) {
        port(8080);

        get("/", (req, res) ->
                render(Collections.emptyMap(), "/index.html")
        );

        post("/name", (req, res) -> {
            String names = req.queryParams("names");
            String[] nameArray = names.split(",");

            Map<String, Object> model = new HashMap<>();
            model.put("names", names);
            model.put("nameArray", nameArray);

            return render(model, "/game.html");
        });

        post("/result", (req, res) -> {
            String names = req.queryParams("names");
            int turn = Integer.parseInt(req.queryParams("turn"));

            List<Car> cars = CarFactory.createCustomShapeCars(names.split(","), "&#128652;");
            RacingGame racingGame = new RacingGame(cars);
            GameResult gameResult = racingGame.move(turn);

            String winnerNames = String.join(", ", gameResult.getWinnerNames());
            List<String> results = gameResult.getCurrentStates();

            Map<String, Object> model = new HashMap<>();
            model.put("winnerNames", winnerNames);
            model.put("results", results);

            return render(model, "/result.html");
        });
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }

}
