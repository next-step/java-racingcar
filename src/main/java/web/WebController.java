package web;

import racing.domain.Car;
import racing.domain.RacingCarGame;
import racing.domain.RacingCarRank;
import racing.view.RacingCarView;
import web.view.WebView;

import java.util.*;

import static spark.Spark.*;

public class WebController {

    private static List<Car> cars;

    public static void main(String[] args) {
        staticFileLocation("templates");

        get("/", (req, res) -> "index.html");

        post("/name", (req, res) -> {

            String params = req.queryParams("names");
            String[] names = RacingCarView.parseCarNames(params);
            cars = RacingCarGame.createCars(names);

            Map<String, Object> model = new HashMap<>();
            model.put("cars", cars);

            return WebView.render(model, "game.html");
        });

        get("/result", (req, res) -> {

            RacingCarGame.startRacing(cars, Integer.parseInt(req.queryParams("turn")));

            for (Car car : cars) {
                WebView.setView(car);
            }

            List<Car> winners = RacingCarRank.rankCars(new ArrayList<>(cars));

            Map<String, Object> model = new HashMap<>();
            model.put("cars", cars);
            model.put("winners", WebView.makeWinnerNameString(winners));

            return WebView.render(model, "result.html");
        });
    }

}
