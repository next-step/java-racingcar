package racing;

import racing.domain.Car;
import racing.domain.RacingGame;
import racing.template.handlebars.BlankHandlebarsTemplateEngine;
import racing.view.ResultView;
import spark.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class WebMain {
    public static void main(String[] args) {
        port(8080);
        staticFiles.location("/templates");
        get("/helloworld", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String name = req.queryParams("name");
            model.put("name", name);
            return render(model, "/helloworld.html");
        });

        get("/hello/:name", (request, response) -> {
            return "Hello: " + request.params(":name");
        });

        post("/name", (req,res) -> {
            Map<String, Object> model = new HashMap<>();
            String names = req.queryParams("names");
            String[] namesSpliit = names.split(" ");
            model.put("names", namesSpliit);
            return render(model, "/game.html");
        });

        get("/result", (req, res) -> {
                    String[] names = req.queryParamsValues("name");
                    Integer time = Integer.valueOf(req.queryParams("turn"));
                    Map<String, Object> model = new HashMap<>();
                    RacingGame racingGame = new RacingGame(names, time);
                    while (racingGame.canContinue()) {
                        List<Car> cars = racingGame.move();
                        ResultView.printAll(cars);
                    }
                    List<Car> winners = RacingGame.getWinners(racingGame.getCars());
                    model.put("cars", racingGame.getCars());
                    model.put("winners", ResultView.joinWinner(winners));
                    return render(model, "/result.html");
                });
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new BlankHandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
