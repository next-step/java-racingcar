package racinggame.view;

import racinggame.domain.RacingGame;
import racinggame.domain.rule.RandomNumberRacingGameRule;
import racinggame.view.handlebars.CustomHandlebarsTemplateEngine;
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

		get("/", (req, res) -> {
			return render(new HashMap<>(), "/index.html");
		});

		post("/name", (req, res) -> {
			String[] names = req.queryParams("names").split(" ");
			HashMap<String, Object> model = new HashMap<>();
			req.session().attribute("names", names);
			model.put("names", names);
			return render(model, "/game.html");
		});

		get("/result", (req, res) -> {
			String[] names = req.session().attribute("names");
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
