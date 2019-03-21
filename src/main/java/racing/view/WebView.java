package racing.view;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racing.domain.Car;
import racing.domain.RacingGame;
import racing.domain.WinnerCars;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class WebView {

  private static final ConsoleInputView consoleInputView = new ConsoleInputView();
  private static final ConsoleResultView consoleResultView = new ConsoleResultView();

  private static final RacingGame racingGame = new RacingGame();

  public static void main(String[] args) {

    port(8080);
    Map<String, Object> model = new HashMap<>();

    get("/", (request, response) -> render(new HashMap<>(), "/index.html"));

    post("/name", (request, response) -> {
      String carNames = request.queryParams("names");
      String[] carNamesArray = carNames.split(" ");
      List<Car> cars = racingGame.generateCars(carNamesArray);
      model.put("cars", cars);

      return render(model, "/game.html");
    });
    get("/result", (request, response) -> {

      int turn = Integer.parseInt(request.queryParams("turn"));
      List<Car> cars = (List<Car>) model.get("cars");
      racingGame.startRacing(cars, turn);
      model.put("cars", cars);

      WinnerCars winnerCars = racingGame.winner(cars);
      model.put("winners", winnerCars.getWinnerNames());

      return render(model, "/result.html");
    });
  }

  public static String render(Map<String, Object> model, String templatePath) {
    return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
  }
}
