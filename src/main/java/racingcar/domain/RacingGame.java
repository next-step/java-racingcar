package racingcar.domain;

import racingcar.view.InputView;
import racingcar.view.ResultView;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.*;

import static spark.Spark.*;

public class RacingGame {
    static final int RANGE_OF_NUM = 10;
    static String str = "";

    private List<Car> cars;

    public RacingGame(String carNames) {
        String names[] = carNames.split(",| ");
        cars = new ArrayList<>();
        for(int i = 0; i < names.length; i++) {
            cars.add(new Car(names[i]));
        }
    }

    public List<Car> onTheGame(Random rand) {
        for(Car car : cars) {
            int currentPos = rand.nextInt(RANGE_OF_NUM);
            car.move(currentPos);
        }
        return cars;
    }

    public static void main(String[] args) {
        WebMain();
    }

    private static void WebMain() {
        port(8080);

        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("cars", "pobi");
            return render(model, "/index.html");
        });

        List<Car> result = new ArrayList<>();

        post("/name", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            str = req.queryParams("names");
            String[] lists = str.split(" ");
            for(int i = 0; i < lists.length; i++) {
                result.add(new Car(lists[i]));
            }
            model.put("cars", result);

            return render(model, "/game.html");
        });

        get("/result", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int turn = Integer.parseInt(req.queryParams("turn"));

            Random rand = new Random();
            RacingGame racingGame = new RacingGame(str);

            for(int i = 0; i < turn; i++) {
                racingGame.cars = racingGame.onTheGame(rand);
            }
            int WinnerNum = WinnerNumber.getWinnerNum(racingGame.cars);
            String WinnerName = ResultView.printWinner(racingGame.cars, WinnerNum);
            model.put("users", racingGame.cars);
            model.put("winner", WinnerName);

            return render(model, "/result.html");
        });
    }

    public static String render(Map<String, Object> model, String templatePath) {
        return new CustomHandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }

    private static void ConsoleMain() {
        Random rand = new Random();
        String carNames = InputView.getCarsNames();
        int racingTracks = InputView.getRacingTracks();

        RacingGame racingGame = new RacingGame(carNames);

        for(int i = 0; i < racingTracks; i++) {
            racingGame.cars = racingGame.onTheGame(rand);
            ResultView.print(racingGame.cars);
            System.out.println();
        }
        int winnerNum = WinnerNumber.getWinnerNum(racingGame.cars);
        System.out.println(ResultView.printWinner(racingGame.cars, winnerNum) + "가 최종 우승했습니다.");
    }
}
