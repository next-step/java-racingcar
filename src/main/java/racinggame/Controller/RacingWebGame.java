package racinggame.Controller;

import racinggame.DTO.WebGame;
import racinggame.domain.Car;
import racinggame.domain.Racing;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static racinggame.Controller.RacingGame.game;
import static racinggame.View.PrintRacing.makeWinnerFormatForPrint;
import static racinggame.View.WebRacing.printWebRacing;
import static spark.Spark.*;
import static spark.Spark.get;

public class RacingWebGame {

    public static void main(String[] args) {
        port(8080);
        List<Racing> racings = new ArrayList<>();

        get("/index", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("name", "SangGu");
            return render(model, "/index.html");
        });

        post("/name", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String inputs = request.queryParams("names");
            Racing racing = new Racing(inputs);
            racings.add(racing);

            model.put("cars", racing.getCars());
            return render(model, "/game.html");
        });

        get("/result", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int tryGame = Integer.parseInt(request.queryParams("turn"));
            List<WebGame> webGames = new ArrayList<>();

            playGame(racings.get(0), tryGame);
            makeWebGame(racings.get(0), webGames);

            model.put("webGames", webGames);
            model.put("winners", makeWinnerFormatForPrint(racings.get(0).getWinners()));

            return render(model, "/result.html");
        });
    }

    private static void makeWebGame(Racing racing, List<WebGame> webGames) {
        for (Car car : racing.getCars()) {
            webGames.add(printWebRacing(car));
        }
    }

    private static void playGame(Racing racing, int tryGame) {
        for (int i = 0; i < tryGame; i++) {
            game(racing);
        }
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
