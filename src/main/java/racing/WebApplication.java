package racing;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.jetty.util.StringUtil;
import racing.domain.RacingCar;
import racing.domain.RacingCarDto;
import racing.domain.RacingGame;
import racing.domain.WinnerCar;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.*;

import static spark.Spark.*;

public class WebApplication {

    public static void main(String[] args) {
        port(8081);

        get("/", (req, res) -> render(null, "/index.html"));

        post( "/name", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("carNames", Arrays.asList(req.queryParams("names").split(" ")));
            return render(model, "/game.html");
        });

        post("/result", (req, res) -> {
            List<String> carNames = Arrays.asList(req.queryParamsValues("carNames"));
            int turn = Integer.parseInt(req.queryParams("turn"));
            RacingGame racingGame = new RacingGame(carNames, turn);

            while(!racingGame.isEnd()) {
                racingGame.playRacing();
            }

            List<RacingCarDto> gameResult = new ArrayList<>();
            racingGame.getRacingCars().forEach(racingCar -> {
                gameResult.add(new RacingCarDto(racingCar.getCarName(), racingCar.getPosition()));
            });

            Map<String, Object> model = new HashMap<>();
            model.put("gameResult", gameResult);
            model.put("winnerNames", String.join(",", new WinnerCar().getWinners(racingGame.getRacingCars())));
            return render(model, "/result.html");
        });
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
