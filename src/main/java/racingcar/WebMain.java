package racingcar;

import static spark.Spark.*;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import racingcar.domain.CarMovableRandomDecider;
import racingcar.domain.RacingGame;
import racingcar.domain.RacingGameState;
import racingcar.domain.RacingResult;
import racingcar.view.WebView;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class WebMain {
    private static String[] carNames;
    private static int tryNo;

    public static void main(String[] args) {
        port(8080);

        get("/", (request, response) -> render(new HashMap<>(), "index.html"));

        post("/name", (request, response) -> {
            carNames = request.queryParams("names").split(" ");
            Map<String, Object> model = new HashMap<>();
            model.put("carNames", carNames);
            return render(model, "game.html");
        });
        get("/result", (request, response) -> {
            tryNo = Integer.parseInt(request.queryParams("turn"));
            RacingGame racingGame = new RacingGame(new CarMovableRandomDecider(), new RacingGameState(carNames, tryNo));
            RacingResult result = null;
            while (!racingGame.isEnd()) {
                result = racingGame.race();
            }
            Map<String, Object> model = new HashMap<>();
            model.put("cars", result.getCars());
            model.put("winners", WebView.getWinnersString(result.getWinners()));
            return render(model, "result.html");
        });
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
