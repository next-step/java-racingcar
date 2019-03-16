package racingcar.view.web.controller;

import racingcar.domain.car.Car;
import racingcar.domain.car.CarRegistration;
import racingcar.domain.race.RacingGame;
import racingcar.domain.race.Ranking;
import racingcar.view.util.ResultView;
import racingcar.view.web.TemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class RacingGameController {

    //TODO : 실무에서도 Constants를 많이 쓰는편인가요?
    //제가 속한 팀의 경우 Constants만 모은 클래스를 만들얻두고 하는데,
    //나중에는 이게 어떤의미인지 알 수 없는경우가 많더라구요..  좋은방법 없을까요?

    private static final String INDEX_PAGE = "index.html";
    private static final String GAME_PAGE = "game.html";
    private static final String RESULT_PAGE = "result.html";

    private static final String NAMES = "names";
    private static final String TURN = "turn";
    private static final String CARS = "cars";
    private static final String WINNERS = "winners";
    private static final String DELIMITER = " ";

    public static void main() {
        //index.html
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return TemplateEngine.render(model, INDEX_PAGE);
        });
    }

    public static void name() {
        //name -> game.html
        post("/name", (request, response) -> {
            String[] names = request.queryParams(NAMES).split(DELIMITER);
            List<Car> cars = CarRegistration.register(names);

            Map<String, Object> model = new HashMap<>();
            model.put(CARS, cars);

            return TemplateEngine.render(model, GAME_PAGE);
        });
    }

    public static void game() {
        //result.html
        get("/result", (request, response) -> {
            int turn = Integer.parseInt(request.queryParams(TURN));
            RacingGame racingGame = new RacingGame(turn);

            //car List를 CarRegistration 인스턴스 변수로 선언하고 getter 사용
            List<Car> cars = racingGame.game(CarRegistration.getCars());

            Map<String, Object> model = new HashMap<>();
            model.put(CARS, cars);

            //winner는 String으로 결과 만들어서 넘김
            Ranking ranking = new Ranking();
            String winners = ResultView.winner(ranking.findWinner(cars));
            model.put(WINNERS, winners);

            return TemplateEngine.render(model, RESULT_PAGE);
        });
    }
}
