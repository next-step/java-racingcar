package racinggame.domain;

import racinggame.dto.WebGameDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static racinggame.view.PrintRacing.makeWinnerFormatForPrint;
import static spark.Spark.*;
import static utils.Render.render;
import static utils.Separator.separateName;

public class WebRacing {

    private List<WebGameDto> webGameDtos;
    private String names;

    public WebRacing() {
        this.webGameDtos = new ArrayList<>();
        this.names = "";
    }
    public void inputNameByGet() {
        get("/index", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("name", "SangGu");
            return render(model, "/index.html");
        });
    }

    public void inputTryGameByPost() {
        post("/name", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            this.names = request.queryParams("names");

            checkNull(this.names);

            String [] players = separateName(this.names);

            for (int i = 0; i < players.length; i++) {
                this.webGameDtos.add(new WebGameDto(players[i]));
            }

            model.put("webGameDtos", this.webGameDtos);
            return render(model, "/game.html");
        });
    }

    public void playGameByGet() {
        get("/result", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int tryGame = Integer.parseInt(request.queryParams("turn"));

            Racing racing = new Racing(this.names, tryGame);

            for (int i = 0; i < tryGame; i++) {
                racing.carForwardStatus();
            }

            List<Car> cars = racing.getCars();

            for (int i = 0; i < this.webGameDtos.size(); i++) {
                WebGameDto webGameDto = this.webGameDtos.get(i);
                Car car = cars.get(i);
                webGameDto.setMoveDistance(car.getCountMoving());
            }

            model.put("webGameDtos", this.webGameDtos);
            model.put("winners", makeWinnerFormatForPrint(racing.getWinners()));

            return render(model, "/result.html");
        });
    }

    public void checkNull(String inputs) {
        if (inputs == null) {
            throw new IllegalArgumentException();
        }
    }
}
