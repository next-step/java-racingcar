package racingcar;

import racingcar.domains.Car;
import racingcar.domains.Cars;
import racingcar.strategies.RandomMoveStrategy;
import racingcar.utils.ParsingUtils;
import racingcar.utils.StringUtils;
import racingcar.views.InputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RacingGame {

    private final int round;
    private final String[] carNames;
    private final Cars cars;
    private final List<Cars> raceResults;


    public RacingGame(Map<String, String> answerMap) {
        round = ParsingUtils.parseStringToInt(answerMap.get(InputView.QUESTION_ROUND));
        carNames = StringUtils.spliter(answerMap.get(InputView.QUESTION_NAMES));
        cars = new Cars();
        raceResults = new ArrayList<>();
    }


    public List<Cars> race() {
        getReadyRacingCars();

        RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategy();

        for (int i = 0; i < round; i++) {
            cars.move(randomMoveStrategy);
            Cars raceResult = cars.clone();
            raceResults.add(raceResult);
        }

        return raceResults;
    }


    private void getReadyRacingCars() {
        for (String carName : carNames) {
            Car newCar = new Car(carName);
            cars.add(newCar);
        }
    }


    public String getWinners() {
        return cars.getWinners();
    }

}
