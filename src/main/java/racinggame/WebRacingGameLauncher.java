package racinggame;

import racinggame.domain.Car;
import racinggame.domain.RacingGame;
import racinggame.view.InputView;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.*;

import static racinggame.view.InputView.WEB_CARNAME_DELIMETER;
import static spark.Spark.*;

public class WebRacingGameLauncher {

    private static List<Car> cars;

    private RacingGame game;

    public static void main(String[] args) {

        port(8080);

        staticFiles.location("/templates");

        get("/", (req, res) -> {
            return render(null, "index.html");
        });

        post( "/name", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            cars = getCars(req.queryParams("names"));
            //model.put("cars", );
            return render(model, "game.html");
        });

        post( "/result", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            /*RacingResult result = new RacingResult(getSessionAttribute(""));
            int numberOfTries = Integer.parseInt(req.queryParams("numberOfTries"));
            for( int i = 0; i < numberOfTries; ++i ) {
                racingGame.proceed(result);
            }*/

            model.put("turn", req.queryParams("turn"));
            return render(model, "result.html");
        });

    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }

    private static List<Car> getCars(String names) {
        return new ArrayList(Arrays.asList(InputView.getCarNames(names, WEB_CARNAME_DELIMETER)));
    }
}