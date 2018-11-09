package racingGame;

import racingGame.domain.RacingCarDTO;
import racingGame.service.RacingCarService;
import spark.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class WebMain {
    private static String[] carNames;

    public static void main(String[] args) {
        port(8080);

        get("/", (req, res) -> render(null, "/index.html"));

        post("/name", (req, res) -> {
            carNames = req.queryParams("names").split(" ");
            Map<String, Object> model = new HashMap<>();
            model.put("names", carNames);
            return render(model, "/game.html");
        });

        get("/result", (req, res) -> {
            int turn = Integer.parseInt(req.queryParams("turn"));

            RacingGame racingGame = new RacingGame(carNames, turn);
            while (racingGame.hasRemainTime()) {
                racingGame.move();
            }

            List<RacingCarDTO> resultSnapshots = null;
            try {
                resultSnapshots = racingGame.getFinishedCarSnapshots();
            } catch (IllegalStateException exception) {
                System.out.println(exception.getMessage());
            } finally {
                RacingCarService racingCarService = new RacingCarService(resultSnapshots);
                int highestPosition = racingCarService.getHighestPosition();

                Map<String, Object> model = new HashMap<>();
                model.put("cars", resultSnapshots);
                model.put("championNames", racingCarService.extractCarNamesByPosition(highestPosition));
                return render(model, "/result.html");
            }
        });
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new CustomHandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}