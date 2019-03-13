package racing.application;

import racing.domain.Car;
import racing.domain.RacingCarGame;
import racing.domain.RacingCarRank;
import racing.view.CommonView;
import racing.view.WebView;

import java.util.*;

import static spark.Spark.*;

public class WebApplication {

    private static List<Car> cars;

    public static void main(String[] args) {
        staticFileLocation("templates");

        get("/", (req, res) -> "index.html");

        post("/name", (req, res) -> {

            String params = req.queryParams("names");
            String[] names = CommonView.parseCarNames(params);

            RacingCarGame racingCarGame = new RacingCarGame();
            cars = racingCarGame.createCars(names);

            Map<String, Object> model = new HashMap<>();
            model.put("cars", cars);

            return WebView.render(model, "game.html");
        });

        get("/result", (req, res) -> {

            RacingCarGame racingCarGame = new RacingCarGame(cars);
            racingCarGame.startRacing(Integer.parseInt(req.queryParams("turn")));

            for (Car car : cars) {
                WebView.setView(car);
            }

            RacingCarRank racingCarRank = new RacingCarRank();
            List<Car> winners = racingCarRank.rankCars(new ArrayList<>(cars));

            Map<String, Object> model = new HashMap<>();
            model.put("cars", cars);
            model.put("winners", WebView.makeWinnerNameString(winners));

            return WebView.render(model, "result.html");
        });
    }

}
