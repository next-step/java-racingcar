package racinggame.view.web;

import racinggame.domain.RacingGame;
import racinggame.domain.car.Car;
import racinggame.domain.rule.RandomNumberRacingGameRule;
import spark.ModelAndView;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

/**
 * Created by hspark on 05/11/2018.
 */
public class RacingGameBoardWeb {
	public static void main(String[] args) {
		port(8080);
		routes();
	}

	private static void routes() {
		get("/", (req, res) -> render(new HashMap<>(), "/index.html"));

		post("/name", (req, res) -> {
			HashMap<String, Object> model = new HashMap<>();
			String[] carNames = req.queryParams("names").split(" ");
			List<Car> carList = Arrays.stream(carNames).map(Car::new).collect(Collectors.toList());

			req.session().attribute("carList", carList);
			model.put("carList", carList);
			return render(model, "/game.html");
		});

		get("/result", (req, res) -> {
			List<Car> carList = req.session().attribute("carList");
			int tryCount = Integer.parseInt(req.queryParams("turn"));
			RacingGame racingGame = new RacingGame(carList, tryCount, new RandomNumberRacingGameRule());
			while (racingGame.hasNextGame()) {
				racingGame.move();
			}

			HashMap<String, Object> model = new HashMap<>();
			model.put("result", racingGame.getGameResult());
			return render(model, "/result.html");
		});
	}

	public static String render(Map<String, Object> model, String templatePath) {
		return new CustomHandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
	}
}
