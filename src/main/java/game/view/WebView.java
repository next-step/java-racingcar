package game.view;


import game.domain.Car;
import game.domain.CarList;
import game.domain.RacingGame;
import game.domain.Winners;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class WebView {
    public static void main(String[] args) {
        port(8080);

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return render(model, "index.html");
        });

        post("/name", (request, response) -> {
            String names = request.queryParams("names");
            List<Car> cars = CarList.makeCars(names);

            Map<String, Object> model = new HashMap<>();
            model.put("cars", cars);
            model.put("names", names);
            return render(model, "game.html");
        });

        post("/result", (request, response) -> {
            int turn = Integer.parseInt(request.queryParams("turn"));
            String names = request.queryParams("names");
            List<Car> cars = null;

            RacingGame racingGame = new RacingGame(names);
            for (int i = 0; i < turn; i++) {
                cars = racingGame.playGame();
            }
            String winners = Winners.findWinners(cars);

            Map<String, Object> model = new HashMap<>();
            model.put("winners", winners);
            model.put("cars",cars);
            return render(model, "result.html");
        });
    }

    private static String render(Map<String, Object> model, String viewName) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, viewName));
    }
}
