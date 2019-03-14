package racing.web;

import racing.board.GameResult;
import racing.board.RacingGameBoard;
import racing.model.RacingCar;
import racing.web.view.InputView;
import racing.web.view.ResultView;
import spark.ModelAndView;
import spark.TemplateEngine;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static spark.Spark.*;

public class WebApplication {

    static final TemplateEngine templateEngine = new HandlebarsTemplateEngine();

    static List<String> carNames;

    public static void main(String[] args) {
        port(8080);

        indexController();
        gameController();
    }

    private static void gameController() {
        post("/name", (request, response) -> {
            carNames = InputView.inputNames(request);
            Map<String, Object> model = new HashMap<>();
            model.put("carNames", carNames);
            return render(model, "/game.html");
        });

        post("/result", (request, response) -> {
            RacingGameBoard board = new RacingGameBoard();
            board.createCars(carNames);

            int timesOfMoves = InputView.inputTime(request);
            GameResult gameResult = board.start(timesOfMoves);

            HashMap<Object, Object> model = new HashMap<>();
            ResultView.viewHistory(model, gameResult.getHistory());
            ResultView.viewWinners(model, gameResult);

            return render(model, "/result.html");
        });
    }

    private static void indexController() {
        get("/", (request, response) -> render("/index.html") );
    }

    private static Object render(String templatePath) {
        return render(new HashMap<>(), templatePath);
    }

    private static Object render(Object model, String templatePath) {
        return templateEngine.render(new ModelAndView(model, templatePath));
    }

}
