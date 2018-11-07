package racingGame;

import racingGame.domain.RacingGame;
import racingGame.dto.GameDto;
import racingGame.dto.ResultDto;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class WebMain {

    public static void main(String[] args) {
        port(8080);

        get("/", (request, response) -> render(Collections.emptyMap(), "index.html"));

        post("/name", (request, response) -> {
            String carNames = request.queryParams("names");

            request.session().attribute("carNames", carNames);

            return render(Collections.singletonMap("carNames", carNames.split(" ")),
                "game.html");
        });

        get("/result", (request, response) -> {
            GameDto gameDto = new GameDto(
                request.session().attribute("carNames"),
                request.queryParams("turn"));

            RacingGame game = runRacingGame(gameDto);

            ResultDto resultDto = new ResultDto(game.getCarsInGame());

            Map<String, Object> model = new HashMap<>();
            model.put("result", resultDto.getRacingResults());
            model.put("winnerNames", resultDto.getWinnerNames());

            return render(model, "result.html");
        });
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }

    public static RacingGame runRacingGame(GameDto gameDto) {
        RacingGame game = new RacingGame(gameDto.getCarNames(), gameDto.getTurn());

        while (game.hasNextRound()) {
            game.move();
        }

        return game;
    }
}
