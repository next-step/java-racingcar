package racing.application;

import racing.domain.Car;
import racing.domain.RacingCarGame;
import racing.domain.RacingCarRank;
import racing.view.CommonView;
import racing.view.WebView;
import racing.view.WebResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class WebApplication {

    private static List<Car> cars;

    public static void main(String[] args) {
        staticFileLocation("templates");

        get("/", (req, res) -> "index.html");

        post("/name", (req, res) -> {
            String[] names = CommonView.parseCarNames(req.queryParams("names"));

            RacingCarGame racingCarGame = new RacingCarGame();
            cars = racingCarGame.createCars(names);

            Map<String, Object> model = new HashMap<>();
            model.put("cars", cars);

            return WebView.render(model, "game.html");
        });

        get("/result", (req, res) -> {
            //레이싱
            RacingCarGame racingCarGame = new RacingCarGame(cars);
            for (int i = 0; i < Integer.parseInt(req.queryParams("turn")); i++) {
                cars = racingCarGame.startRound(cars);
            }

            //랭킹
            RacingCarRank racingCarRank = new RacingCarRank();
            List<Car> winners = racingCarRank.rankCars(new ArrayList<>(cars));

            //set result model
            WebResult webResult = WebView.makeCarInfo(cars);
            WebView.makeWinnerNameString(winners);

            Map<String, Object> model = new HashMap<>();
            model.put("result", webResult);

            return WebView.render(model, "result.html");
        });
    }

}
