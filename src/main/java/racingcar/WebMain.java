package racingcar;

import racingcar.domain.RacingGame;
import racingcar.view.CarNameParser;
import racingcar.vo.RacingGameParameter;
import racingcar.vo.RacingResultOfRound;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import static spark.Spark.*;

public class WebMain {
    private static ConcurrentMap<String, RacingGame> racingGameStore = new ConcurrentHashMap<>();
    private static final int MINIMUM_ROUND = 1;

    public static void main(String[] args) {
        port(8080);

        get("/", (request, response) -> render(null, "index.html"));

        post("/name", (request, response) -> {
            String names = request.queryParams("names");

            Map<String, Object> model = new HashMap<>();
            model.put("names", names);
            model.put("carNames", CarNameParser.parseWhiteSpaceCarNamesString(names));

            return render(model, "game.html");
        });

        get("/result", (request, response) -> {
            String names = request.queryParams("names");
            String turn = request.queryParams("turn");
            int totalRound = Integer.parseInt(turn);
            totalRound = ((totalRound < MINIMUM_ROUND) ? MINIMUM_ROUND : totalRound);

            RacingGame racingGame = getRacingGame(names, totalRound);
            RacingResultOfRound racingResult = racingGame.race();

            if (racingGame.isEnd()) {
                removeRacingGame(names, totalRound);
            }

            Map<String, Object> model = new HashMap<>();
            model.put("raceResult", racingResult);
            model.put("isEnd", racingGame.isEnd());
            model.put("winners", racingResult.getWinners());

            return render(model, "result.html");
        });
    }

    private static String render(Map<String, Object> model, String templatePath) {
        ModelAndView modelAndView = new ModelAndView(model, templatePath);
        return new HandlebarsTemplateEngine().render(modelAndView);
    }

    private static RacingGame getRacingGame(String carNamesString, int totalRound) {
        String key = getKey(carNamesString, totalRound);
        RacingGame racingGame = racingGameStore.get(key);

        if (null == racingGame) {
            racingGame = createNewRacingGame(carNamesString, totalRound);
            racingGameStore.put(key, racingGame);
        }

        return racingGame;
    }

    private static RacingGame createNewRacingGame(String carNamesString, int totalRound) {
        List<String> carNames = CarNameParser.parseWhiteSpaceCarNamesString(carNamesString);
        RacingGameParameter parameter = new RacingGameParameter(carNames, totalRound);

        return new RacingGame(parameter);
    }

    private static void removeRacingGame(String carNamesString, int totalRound) {
        String key = getKey(carNamesString, totalRound);
        racingGameStore.remove(key);
    }

    private static String getKey(String carNames, int totalRound) {
        return carNames + totalRound;
    }
}
