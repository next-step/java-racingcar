package racinggame.view.web;

import static spark.Spark.exception;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.HashMap;
import java.util.Map;
import racinggame.domain.RacingGame;
import racinggame.domain.RacingGameResult;
import racinggame.dto.RacingGameInfo;
import spark.ModelAndView;
import spark.Session;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class RacingGameWeb {

	private static final String DISPLAY_CHARACTER = "\uD83D\uDE8C";

	public static void main(String[] args) {
		port(8080);
		routes();
	}

	private static void routes() {
		get("/", (req, res) -> {
			Map<String, Object> model = new HashMap<>();
			return render(model, "/index.html");
		});

		post("/name", (req, res) -> {
			final String carNames = req.queryParams("names");
			RacingGameInfo racingGameInfo = new RacingGameInfo(carNames, 0);
			Session session = req.session();
			session.attribute("racingGameInfo", racingGameInfo);
			Map<String, Object> model = new HashMap<>();
			model.put("cars", racingGameInfo.readyCar());
			return render(model, "/game.html");
		});

		post("/result", (req, res) -> {
			final int time = Integer.parseInt(req.queryParams("turn"));
			Session session = req.session();
			RacingGameInfo racingGameInfo = session.attribute("racingGameInfo");
			racingGameInfo.setTime(time);
			RacingGame racingGame = new RacingGame(racingGameInfo);
			do {
				racingGame.move();
			} while(!racingGame.isOver());
			Map<String, Object> model = new HashMap<>();
			RacingGameResult racingGameResult = racingGame.getRacingGameResult();
			model.put("cars", racingGameResult.getPrintPositions(DISPLAY_CHARACTER));
			model.put("winners", racingGameResult.getWinnerNames());
			return render(model, "/result.html");
		});

		exception(Exception.class, (exception, req, res) -> {
			res.redirect("/");
		});
	}

	private static String render(Map<String, Object> model, String templatePath) {
		return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
	}
}
