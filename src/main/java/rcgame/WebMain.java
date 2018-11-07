package rcgame;

import rcgame.domain.RcGame;
import rcgame.dto.RcGameRequest;
import rcgame.template.handlebar.CustomHandlebarsTemplateEngine;
import rcgame.util.NumberGenerator;
import rcgame.util.RandomNumberGenerator;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

import static rcgame.domain.RcGame.identifyWinner;
import static spark.Spark.*;
import static spark.utils.StringUtils.isEmpty;


public class WebMain {
    public static void main(String[] args) {
        NumberGenerator numberGenerator = new RandomNumberGenerator();

        port(8080);

        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return render(model, "/index.html");
        });

        post("/name", (req, res) -> {
            String reqNames = req.queryParams("names");

            if(isEmpty(reqNames)) {
                throw new InvalidParameterException("차 이름을 입력하세요.");
            }

            Map<String, Object> model = new HashMap<>();
            String[] rcCarNames = reqNames.split(" ");

            req.session().attribute("names", rcCarNames);
            model.put("names", rcCarNames);
            return render(model, "/game.html");
        });

        get("/result", (Request req, Response res) -> {
            String reqTurn = req.queryParams("turn");
            String[] names = req.session().attribute("names");

            if(isEmpty(reqTurn)) {
                throw new InvalidParameterException("시도 횟수를 입력하세요.");
            }

            RcGame rcGame = new RcGame(new RcGameRequest(names, Integer.parseInt(reqTurn)));
            while(rcGame.isOnGoing()) {
                rcGame.race(numberGenerator);
            }

            Map<String, Object> model = new HashMap<>();
            model.put("rgCars", rcGame.getRcCars());
            model.put("winnerRcCars", identifyWinner(rcGame.getRcCars()));
            return render(model, "/result.html");
        });

        exception(InvalidParameterException.class, (e, req, res) -> {
            res.status(401);
            res.body(e.getMessage());
        });

        exception(Exception.class, (e, req, res) -> {
            res.status(500);
            res.body(e.getMessage());
            e.printStackTrace();
        });
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new CustomHandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }

}
