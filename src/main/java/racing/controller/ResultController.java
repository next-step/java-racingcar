package racing.controller;

import racing.CarGameRuleUseRandomNumber;
import racing.GameRule;
import racing.domain.RacingGame;
import racing.domain.RacingGameResult;
import racing.dto.Car;
import racing.dto.CarRoundResult;
import racing.view.webview.RacingGameWebResultView;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class ResultController {
    private static final String TEMPLATE_NAME = "/result.html";

    public static String get(Request req, Response res) {
        int time = Integer.parseInt(req.queryParams("turn"));
        List<String> carNames = new ArrayList<String>();
        Stream<String> stream = Arrays.stream(req.queryParamsValues("names"));
        stream.forEach(name -> carNames.add(name));

        RacingGame racingGame = new RacingGame(time, carNames);
        GameRule gameRule = new CarGameRuleUseRandomNumber();
        RacingGameResult racingGameResult = racingGame.runRacingGame(gameRule);

        List<CarRoundResult> cars = racingGameResult.findLastRoundCars();
        List<String> winners = racingGameResult.findRacingWinner();

        Map<String, Object> model = RacingGameWebResultView.getRacingGameResultModel(cars, winners);

        return new HandlebarsTemplateEngine().render(new ModelAndView(model, TEMPLATE_NAME));
    }
}
