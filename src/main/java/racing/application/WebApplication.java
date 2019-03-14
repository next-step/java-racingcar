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

            String params = req.queryParams("names");
            String[] names = CommonView.parseCarNames(params);

            RacingCarGame racingCarGame = new RacingCarGame();
            cars = racingCarGame.createCars(names);

            Map<String, Object> model = new HashMap<>();
            model.put("cars", cars);

            WebView webView = new WebView();
            return webView.render(model, "game.html");
        });

        get("/result", (req, res) -> {

            RacingCarGame racingCarGame = new RacingCarGame(cars);
            for (int i = 0; i < Integer.parseInt(req.queryParams("turn")); i++) {
                cars = racingCarGame.startRound(cars);
            }

            RacingCarRank racingCarRank = new RacingCarRank();
            List<Car> winners = racingCarRank.rankCars(new ArrayList<>(cars));

            WebView webView = new WebView();
            WebResult webResult = webView.setView(cars);
            webView.makeWinnerNameString(winners);

            Map<String, Object> model = new HashMap<>();
            model.put("result", webResult);

            return webView.render(model, "result.html");
        });
    }

}
