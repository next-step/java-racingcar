package racingcar;


import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.view.WebRacingResult;
import racingcar.view.WebResultView;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.*;

import static spark.Spark.*;

public class WebMain {
    private static List<String> carNames;
    private static int time;

    public static void main(String[] args) {
        staticFiles.location("/templates");
        port(8080);


        get("/hello", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("name", "anjaemin");

            return render(model, "/index.html");
        });

        post("/name", (req, res) -> {
            String names = req.queryParams("names");
            carNames = Arrays.asList(names);
            String[] nameArray = names.replaceAll("\\s", "").split(",");
            Map<String, Object> model = new HashMap<>();

            model.put("names", nameArray);

            return render(model, "/game.html");
        });

        get("/result", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String turn = req.queryParams("turn");
            time = Integer.parseInt(turn);
            List<Car> cars = new ArrayList<>();
            for (String carName : carNames) {
                cars.add(new Car(carName, 0));
            }

            RacingGame racingGame = new RacingGame(cars, time);

            List<Car> racingResults = racingGame.racing();
            List<Car> winners = racingGame.getWinners(racingResults);
            WebResultView webResultView = new WebResultView();
            List<WebRacingResult> webRacingResults = webResultView.webResults(cars);
            model.put("cars", webRacingResults);
            model.put("winners", webResultView.webWinner(winners));

            return render(model, "/result.html");
        });
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
