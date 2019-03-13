package racingcar.web;

import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.utils.RandomGeneratorImpl;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.web.dto.RaceResultDTO;
import racingcar.web.dto.RunResultDTO;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

public class WebApplication {
    private static final int MAX_RANGE = 10;
    private static final String REGEX = " ";
    private static List<String> names;

    public static void main(String[] args) {
        port(8080);

        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return render(model, "/index.html");
        });

        post("/name", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            Scanner scanner = new Scanner(req.queryParams("names"));
            names = InputView.getStringList("", REGEX, scanner);
            System.out.println(names);
            model.put("names", names);
            return render(model, "/game.html");
        });

        post("/result", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int tryCount = Integer.parseInt(req.queryParams("turn"));

            RacingGame racingGame = new RacingGame(names, new RandomGeneratorImpl(MAX_RANGE));
            List<RaceResultDTO> racingGameResult = new ArrayList<>();

            for (int i = 0; i < tryCount; i++) {
                RaceResultDTO raceResultDTO = new RaceResultDTO(new ArrayList<>());
                for (Car car : racingGame.getCars()) {
                    racingGame.run(car);
                    raceResultDTO.getRunResults()
                        .add(new RunResultDTO(car.getName(), OutputView.generateRaceResultString(car)));
                }
                racingGameResult.add(raceResultDTO);
            }

            model.put("racingGameResult", racingGameResult);
            model.put("winners", OutputView.generateWinnersString(racingGame.getCars()));

            return render(model, "/result.html");
        });
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
