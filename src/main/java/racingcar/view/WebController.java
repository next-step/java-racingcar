package racingcar.view;

import racingcar.domain.CarMovableRandomDecider;
import racingcar.domain.RacingGame;
import racingcar.domain.RacingGameState;
import racingcar.domain.RacingResult;

import java.util.*;

import spark.ModelAndView;
import spark.Route;
import spark.template.handlebars.HandlebarsTemplateEngine;

import static spark.Spark.*;

public class WebController {
    private static String[] carNames;
    private static int tryNo;

    public void start(int port) {
        port(port);

        get("/", getIndexPage());
        post("/name", getNamePage());
        get("/result", getResultPage());
    }

    public static Route getIndexPage() {
        return (request, response) -> render(new HashMap<>(), "index.html");
    }

    public static Route getNamePage() {
        return (request, response) -> {
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
        };
    }

    public static Route getResultPage() {
        return (request, response) -> {
            carNames = request.queryParams("names").split(" ");

            Map<String, Object> model = new HashMap<>();
            model.put("carNames", carNames);
            return render(model, "game.html");
        };
    }

    private static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
