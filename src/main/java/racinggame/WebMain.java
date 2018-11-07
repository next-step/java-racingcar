package racinggame;

import racinggame.template.handlebar.CustomHandlebarsTemplateEngine;
import racinggame.model.Car;
import racinggame.model.RacingGame;
import racinggame.model.RacingGameResult;
import spark.ModelAndView;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;
import static spark.utils.StringUtils.isEmpty;

public class WebMain {

    private static final String COMMA = ", ";
    private static final String NBSP = "&nbsp;";

    public static void main(String[] args) {
        port(8080);

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return render(model, "/index.html");
        });

        post("/name", (request, response) -> {
            String requestNames = request.queryParams("names");
            if(isEmpty(requestNames)) {
                throw new InvalidParameterException("차 이름을 입력하세요.");
            }

            Map<String, Object> model = new HashMap<>();
            String[] names = requestNames.split(" ");

            request.session().attribute("names", names);
            model.put("names", names);
            return render(model, "/game.html");
        });

        post("/result", (request, response) -> {
            String requestTurn = request.queryParams("turn");
            if(isEmpty(requestTurn)) {
                throw new InvalidParameterException("시도 횟수를 입력하세요.");
            }

            String[] names = request.session().attribute("names");
            RacingGame racingGame = new RacingGame(names, Integer.parseInt(requestTurn));

            List<Car> racingResultCars = null;
            while(!racingGame.isRaceEnd()) {
                racingResultCars = racingGame.raceOneTime();
            }
            RacingGameResult racingGameResult = new RacingGameResult(racingResultCars);

            Map<String, Object> model = new HashMap<>();
            model.put("racingResultCars", racingResultCars);
            model.put("winner", String.join(COMMA, racingGameResult.getWinner()));

            return render(model, "/result.html");
        });

        exception(InvalidParameterException.class, (e, request, response) -> {
            response.status(401);
            response.body(e.getMessage());
        });

        exception(Exception.class, (e, request, response) -> {
            response.status(500);
            response.body(e.getMessage());
            e.printStackTrace();
        });

    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new CustomHandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
