package racinggame.view.web;

import racinggame.domain.car.Car;
import racinggame.domain.car.CarGroup;
import racinggame.domain.game.RacingGame;
import racinggame.domain.rule.RandomNumberRacing;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static spark.Spark.*;

public class GameWeb {
    public static void main(String[] args) {
        port(8080);

        get("/", (req, res) -> render(new HashMap<>(), "/index.html"));

        post("/name", (req, res) -> {
            Map cars = new HashMap();
            String[] names = req.queryParams("names").split(" ");
            CarGroup carGroup = new CarGroup(names);
            cars.put("cars", carGroup.getGroupCars());

            req.session().attribute("names", names);
            return render(cars, "/game.html");
        });

        post("/result", (req, res) -> {
            Map cars = new HashMap();
            int turn = Integer.parseInt(req.queryParams("turn"));
            RacingGame racingGame = new RacingGame(req.session().attribute("names"), turn, new RandomNumberRacing());
            while (racingGame.nextRacingGame()){
                racingGame.move();
            }

            cars.put("cars", racingGame.getCar());
            cars.put("victoryCarNames", racingGame.getVictorCar().stream().collect(Collectors.joining(",")));
            return render(cars, "/result.html");
        });

    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new CustomLocationTemplateEngine().render(new ModelAndView(model, templatePath));
    }

}
