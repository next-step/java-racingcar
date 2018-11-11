package racingcar.mainapp;

import racingcar.domain.Car;
import racingcar.domain.CarCollection;
import racingcar.domain.RacingGame;
import spark.ModelAndView;
import racingcar.view.CustomHandlebarsTemplate;
import racingcar.view.ResultView;

import java.util.*;

import static spark.Spark.*;

public class WebMain {

    public static void main(String[] args){
        port(8080);
        staticFiles.location("/templates");

        get("/", (req, res) -> {
           return "index.html";
        });

        post("/name", (req, res) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("input", req.queryParams("names"));
            model.put("names", req.queryParams("names").split(" "));

            return render(model, "game.html");
        });

        get("/result", (req, res) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            RacingGame game = new RacingGame(req.queryParams("names").split(" "), Integer.parseInt(req.queryParams("turn")));
            CarCollection carCollection = new CarCollection(game.getCars());
            List<Car> cars = new ArrayList<>();

            for(int i = 0; i < game.getTime(); i++){
                cars = game.move();
            }

            model.put("cars", cars);
            model.put("winners", ResultView.printWinner(carCollection.decideWinner(game.getCars())));

            return render(model, "result.html");
        });
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new CustomHandlebarsTemplate().render(new ModelAndView(model, templatePath));
    }
}
