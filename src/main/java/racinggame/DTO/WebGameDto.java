package racinggame.dto;

import racinggame.domain.Car;
import racinggame.domain.Racing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static racinggame.controller.RacingGame.playGame;
import static racinggame.view.PrintRacing.makeWinnerFormatForPrint;
import static spark.Spark.*;
import static utils.Render.render;

public class WebGameDto {
    private String player;
    private StringBuilder moveDistance;

    public WebGameDto(Car car, StringBuilder moveDistance) {
        port(8080);
        this.player = car.getName();
        this.moveDistance = moveDistance;
    }

    public String getPlayer() {
        return player;
    }

    public StringBuilder getMoveDistance() {
        return moveDistance;
    }

    public static void playGameByGet(List<Racing> racings) {
        get("/result", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int tryGame = Integer.parseInt(request.queryParams("turn"));
            List<WebGameDto> webGameDtos = new ArrayList<>();

            checkNull(racings);

            playGame(racings.get(0), tryGame);
            racings.get(0).makeWebGame(webGameDtos);

            model.put("webGameDtos", webGameDtos);
            model.put("winners", makeWinnerFormatForPrint(racings.get(0).getWinners()));

            return render(model, "/result.html");
        });
    }

    public static void inputTryGameByPost(List<Racing> racings) {
        post("/name", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String inputs = request.queryParams("names");
            Racing racing = new Racing(inputs, 0);

            checkNull(racings);

            racings.add(racing);

            model.put("cars", racing.getCars());
            return render(model, "/game.html");
        });
    }

    public static void inputNameByGet() {
        get("/index", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("name", "SangGu");
            return render(model, "/index.html");
        });
    }

    public static void checkNull(List<Racing> racings) {
        if(racings.get(0) == null) {
            throw new IllegalArgumentException();
        }
    }
}
