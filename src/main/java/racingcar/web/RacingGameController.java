package racingcar.web;

import racingcar.view.CarNameParser;
import racingcar.vo.RacingResultOfRound;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class RacingGameController {
    private final RacingGameService racingGameService;

    public RacingGameController(RacingGameService racingGameService) {
        this.racingGameService = racingGameService;
    }

    public void start(int port) {
        port(port);

        index();
        game();
        result();
    }

    public void index() {
        get("/", (request, response) -> render(null, "index.html"));
    }

    public void game() {
        post("/name", (request, response) -> {
            String names = request.queryParams("names");

            Map<String, Object> model = new HashMap<>();
            model.put("names", names);
            model.put("carNames", CarNameParser.parseWhiteSpaceCarNamesString(names));

            return render(model, "game.html");
        });
    }

    public void result() {
        get("/result", (request, response) -> {
            RacingResultOfRound racingResult = racingGameService.race(request);
            boolean isEnd = racingGameService.isRacingEnd(request);

            Map<String, Object> model = new HashMap<>();
            model.put("raceResult", racingResult);
            model.put("isEnd", isEnd);
            model.put("winners", racingResult.getWinners());

            return render(model, "result.html");
        });
    }

    private static String render(Map<String, Object> model, String templatePath) {
        ModelAndView modelAndView = new ModelAndView(model, templatePath);
        return new HandlebarsTemplateEngine().render(modelAndView);
    }
}
