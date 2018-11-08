package racingCar;

import racingCar.domain.GameResult;
import racingCar.domain.RacingGame;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static racingCar.Car.getNamesFromList;
import static racingCar.domain.GameResult.getWinnerList;
import static spark.Spark.*;

public class WebMain {
    public static  void main(String[] args) {

        port(8080);

        get("/",(req,res) -> {
            Map<String, Object> model = new HashMap<>();
            return render(model, "/index.html");
        });

        post("/name", (req, res) -> {
            String names = req.queryParams("names").replaceAll(" ",",");
            req.session().attribute("carNames", names);
            RacingGame cars = new RacingGame(names);
            Map<String, Object> model = new HashMap<>();
            model.put("cars", cars.getCarList());

            return render(model, "game.html");
        });

        post("/result", (req,res) -> {
            Map<String, Object> model = new HashMap<>();
            GameResult result = new GameResult();
            RacingGame rc = new RacingGame(req.session().attribute("carNames"));
            String tryNo = req.queryParams("turn");

            for(int i=0; i<Integer.parseInt(tryNo);i++){
                result = rc.move();
            }
            model.put("cars", result.getResultList());

            List<String> winnerList = getNamesFromList(result.getWinnerCar());
            String winner = getWinnerList(winnerList);
            model.put("winners", winner);

            return render(model, "result.html");

        });
    }

        public static String render(Map<String, Object> model, String templatePath) {
            return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
        }
}
