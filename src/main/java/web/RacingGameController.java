package web;

import domain.RacingGameInfo;
import domain.RacingGameResult;
import domain.Session;
import service.RacingGameService;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import util.StringParser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class RacingGameController {
    private final RacingGameService racingGameService = new RacingGameService();

    public void index(){
        get("/", (request, response) -> render(null, "/index.html"));
    }


    public void name(){
        post("/name", (request, response) -> {
            Map<String, Object> model = new HashMap<>();

            String names = request.queryParams("names");

            Session.put("names", names);
            model.put("names", StringParser.split(names, " "));

            return render(model, "/game.html");
        });
    }

    public void result(){
        get("/result", (request, response) -> {
            Map<String, Object> model = new HashMap<>();

            Integer turn = Integer.parseInt(request.queryParams("turn"));
            List<String> carNames = StringParser.split(Session.get("names"), " ");
            Session.clear();

            RacingGameInfo racingGameInfo = racingGameService.initGameInfo(turn, carNames);
            RacingGameResult racingGameResult = racingGameService.playGames(racingGameInfo);

            model.put("result", racingGameResult);

            return render(model, "/result.html");
        });
    }

    private static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
