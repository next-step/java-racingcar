package racinggame.view.web;

import racinggame.domain.RacingGame;
import racinggame.domain.rule.RandomNumberRacingGameRule;
import spark.ModelAndView;

import java.util.HashMap;
import java.util.Map;

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
			model.put("names", req.queryParams("names").split(" "));
			return render(model, "/game.html");
		});

		get("/result", (req, res) -> {
			String[] names = req.queryParamsValues("names");
			int tryCount = Integer.parseInt(req.queryParams("turn"));
			RacingGame racingGame = new RacingGame(names, tryCount, new RandomNumberRacingGameRule());
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
