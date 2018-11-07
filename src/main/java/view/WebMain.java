package view;

import domain.Car;
import domain.CarResult;
import domain.RacingGame;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.*;

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

        post("/name",(req, res) -> {
            Map<String, Object> model = new HashMap<>();

            String names = req.queryParams("names");
            String[] name = names.split(" ");
            List<Car> cars = new ArrayList<>();

            for(int i =0; i < name.length; i++){
                cars.add(new Car(name[i]));
            }
            req.session().attribute("cars",cars);
            model.put("cars",cars);
            return render(model, "/game.html");
        });

        get("/result",(req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Car> cars =  req.session().attribute("cars");
            int turn = Integer.parseInt(req.queryParams("turn"));
            RacingGame racingGame = new RacingGame(cars, turn);

            for(int i =0; i < turn; i++){
                cars = racingGame.move();
            }

            String result = CarResult.getRaceWinners(cars);

            model.put("cars",cars);
            model.put("result", result);

            return render(model, "/result.html");
        });

    }


    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
