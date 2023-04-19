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
        List<Car> carList = new ArrayList<>();
        for (String carName : carNameList) {
            carList.add(new Car(carName));
        }

        this.cars = new Cars(carList);
        this.racingRule = racingRule;
    }

    public GameResult start(int opportunity) {
        List<RoundResult> totalResult = new ArrayList<>();
        for (int i = 0; i < opportunity; i++) {
            totalResult.add(cars.race(racingRule));
        }
        return new GameResult(totalResult);
    }
}
