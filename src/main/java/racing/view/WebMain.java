package racing.view;

import static spark.Spark.*;

import racing.domain.Car;
import racing.domain.RacingGame;
import racing.domain.RacingResult;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebMain {
    public static void main(String args[]) {

        port(8080);

        get("/start", (req, res) -> render(null, "index.html"));

        post("/name", (req, res) -> {
            String input = req.queryParams("names");
            String[] carNames = input.split(" ");

            List<Car> cars = new ArrayList<>();

            for(String carName:carNames){
                cars.add(new Car(0,carName));
            }

            Map<String, Object> model = new HashMap<>();
            model.put("cars", cars);
            req.session().attribute("input",input);
            return render(model, "game.html");
        });

        get("/result", (req, res) -> {
            int timeToTry = Integer.parseInt(req.queryParams("turn"));

            String input = req.session().attribute("input");
            String[] carNames = input.split(" ");

            RacingGame racingGame = new RacingGame(carNames, timeToTry);
            RacingResult result = null;

            while(racingGame.isEnd()) {
                result = racingGame.race();
            }

            Map<String, Object> model = new HashMap<>();

            model.put("cars", racingGame.getCars());
            model.put("winner",result.getWinners());

            return render(model, "result.html");
        });
    }

    private static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
