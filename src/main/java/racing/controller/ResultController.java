package racing.controller;

import racing.CarGameRuleUseRandomNumber;
import racing.GameRule;
import racing.domain.RacingGame;
import racing.domain.RacingGameResult;
import racing.dto.Car;
import racing.view.webview.RacingGameWebResultView;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ResultController {
    private static final String TEMPLATE_NAME = "/result.html";

    public static String get(Request req, Response res) {
        int time = Integer.parseInt(req.queryParams("turn"));
        String[] userNames = req.queryParamsValues("names");

        List<String> carNames = new ArrayList<String>();
        for (String userName : userNames) {
            carNames.add(userName);
        }

        RacingGame racingGame = new RacingGame(time, carNames);
        GameRule gameRule = new CarGameRuleUseRandomNumber();
        RacingGameResult racingGameResult = racingGame.runRacingGame(gameRule);

        List<Car> cars = racingGame.getCars();
        List<String> winners = racingGameResult.findRacingWinner();

        Map<String, Object> model = RacingGameWebResultView.getRacingGameResultModel(cars, winners);

        return new HandlebarsTemplateEngine().render(new ModelAndView(model, TEMPLATE_NAME));
    }

    public static String post(Request req, Response res) {
        return null;
    }
}
