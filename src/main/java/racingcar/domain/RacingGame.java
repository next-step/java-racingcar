package racingcar.domain;

import racingcar.domain.input.InputCarCount;
import racingcar.domain.input.InputRoundCount;
import racingcar.util.ConditionGenerator;
import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private InputCarCount carCount;
    private InputRoundCount roundCount;
    private List<Car> cars;

    public RacingGame(InputCarCount carCount, InputRoundCount roundCount) {
        if (isNull(carCount, roundCount)) {
            throw new IllegalArgumentException();
        }
        init(carCount, roundCount);
    }

    private void init(InputCarCount carCount, InputRoundCount roundCount) {
        this.carCount = carCount;
        this.roundCount = roundCount;
        this.cars = new ArrayList<>();
        for (int i = 0; i < carCount.getCarCount(); i++) {
            this.cars.add(new Car());
        }
    }

    private boolean isNull(InputCarCount carCount, InputRoundCount roundCount) {
        return carCount == null || roundCount == null;
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public int play() {
        int tryCount = 0;
        for (int i = 0; i < roundCount.getRoundCount(); i++) {
            cars.forEach(car -> car.stopOrGo(ConditionGenerator.getInstance().generateRandomCondition()));
            tryCount++;
            ResultView.renderResultView(cars, tryCount);
        }
        return tryCount;
    }
}
