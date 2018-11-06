package racing;

import racing.domain.GameResult;
import racing.domain.RacingGame;
import racing.view.ResultView;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

public class WebMain {
    public static void main(String[] args) {

        port(8080);

        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return render(model, "/index.html");
        });

        post("/name", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            String names = req.queryParams("names");
            req.session().attribute("carName", names);

            String[] carNames = names.split(" ");
            List<Car> cars = new ArrayList<>();

            for (int i = 0; i < carNames.length; i++) {
                cars.add(new Car(carNames[i]));
            }

            model.put("cars", cars);
            return render(model, "/game.html");
        });

        post("/result", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            String carNames = req.session().attribute("carName");
            String tryNo = req.queryParams("turn");

            RacingGame racingGame = new RacingGame(carNames);
            List<GameResult> gameResults = new ArrayList<>();

            for (int i = 0; i < Integer.parseInt(tryNo); i++) {
                gameResults.add(racingGame.startGame());
            }
            model.put("results", gameResults);
            model.put("winner", gameResults.get(gameResults.size()-1).getWinner());

            return render(model, "/result.html");
        });
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
