package racing;

import racing.domain.Car;
import racing.domain.Cars;
import racing.domain.GameResult;
import racing.domain.RoundResult;
import racing.rule.RacingRule;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final Cars cars;
    private final RacingRule racingRule;

    public RacingGame(List<String> carNames, RacingRule racingRule) {
        this.cars = new Cars(convertToCarList(carNames));
        this.racingRule = racingRule;
    }

    private List<Car> convertToCarList(List<String> carNames) {
        List<Car> resultCars = new ArrayList<>();
        for (String carName : carNames) {
            resultCars.add(new Car(carName));
        }
        return resultCars;
    }

    public GameResult start(int opportunity) {
        GameResult gameResult = new GameResult(cars.valueOfEntryNameList());
        for (int i = 0; i < opportunity; i++) {
            cars.race(racingRule);
            gameResult.addRound(cars.currentRoundResult());
        }
        return gameResult;
    }
}
