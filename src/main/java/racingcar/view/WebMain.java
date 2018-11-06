package racingcar.view;

import racingcar.domain.*;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.*;
import java.util.stream.Collectors;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

public class WebMain {
    public static void main(String[] args) {
        port(8080);

        get("/", (req, res) -> render(null, "index.html"));

        post("/name", (req, res) -> {
            String requestParam = req.queryParams("names");
            String [] cars = requestParam.split(" ");

            List<RacingCar> racingCars = Arrays.stream(cars)
                    .map(car -> new RacingCar(0, car))
                    .collect(Collectors.toList());

            RacingCarRepository.racingCars = requestParam;

            Map<String, Object> model = new HashMap<>();

            model.put("cars", racingCars);

            return render(model, "game.html");
        });

        get("/result", (req, res) -> {
            int tryTime = Integer.parseInt(req.queryParams("turn"));
            String cars = RacingCarRepository.racingCars;

            Racing racing = new Racing(cars.replaceAll(" ", ","));
            GameResult result;

            for(int i = 0; i < tryTime; i++) {
                racing.moveCars();
            }

            result = new GameResult(racing.getRacingCars());

            Map<String, Object> model = new HashMap<>();

            model.put("cars", racing.getRacingCars());
            model.put("winner", result.winner());

            return render(model, "result.html");
        });
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
