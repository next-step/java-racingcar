import racingGame.domain.Car;
import racingGame.domain.RacingGame;
import racingGame.view.InputView;
import racingGame.view.InputViewImpl;
import racingGame.view.OutputView;
import racingGame.view.OutputViewImpl;
import spark.ModelAndView;
import spark.Session;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.security.InvalidParameterException;
import java.util.*;

import static spark.Spark.*;

public class WebMain {

	public static void main(String[] args) throws Exception {
		port(8080);

		get("/", (req, res) -> {
			Map<String, Object> model = new HashMap<>();
			return render(model, "index.html");
		});

		post("/name", (req,res) -> {
			Map<String, Object> model = new HashMap<>();
			String names = Optional
					.ofNullable(req.queryParams("names"))
					.orElseThrow(InvalidParameterException::new);
			List<String> carNameList = Arrays.asList(names.split(" "));

			Session session = req.session();
			session.attribute("names", names);

			model.put("carNameList", carNameList);

			return render(model, "game.html");
		});

		post("/result", (req,res) -> {
			Session session = req.session();

			Map<String, Object> model = new HashMap<>();

			InputView inputView = new InputViewImpl();
			OutputView outputView = new OutputViewImpl();

			// 파라미터 turn
			int intTurn = Integer.parseInt(Optional
					.ofNullable(req.queryParams("turn"))
					.orElseThrow(InvalidParameterException::new));

			// 파라미터 carsList
			String names = Optional
					.ofNullable((String)session.attribute("names"))
					.orElseThrow(InvalidParameterException::new);

			String[] carsNameList = names.split(" ");

			inputView.setInputCarsName(carsNameList);
			inputView.setInputRunDistance(intTurn);

			RacingGame racingGame = new RacingGame(inputView, outputView);
			racingGame.gameStart();

			List<Car> cars = racingGame.getCarList();
			List<String> winnerCars = Arrays.asList(racingGame.getWinners());

			model.put("cars", cars);
			model.put("winCars", Arrays.asList(winnerCars));

			return render(model, "result.html");
		});
	}

	private static String render(Map<String, Object> model, String templatePath) {
		return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
	}

}
