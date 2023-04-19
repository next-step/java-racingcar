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

    public RacingGame(List<String> carNameList, RacingRule racingRule) {
        this.cars = new Cars(convertToCarList(carNameList));
        this.racingRule = racingRule;
    }

    private List<Car> convertToCarList(List<String> carNameList) {
        List<Car> carList = new ArrayList<>();
        for (String carName : carNameList) {
            carList.add(new Car(carName));
        }
        return carList;
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
