package racingcar.domain;

import racingcar.domain.input.InputCarCount;
import racingcar.domain.input.InputRoundCount;
import racingcar.util.ConditionGenerator;
import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private static final String MESSAGE_RESULT = "실행결과";

    private InputCarCount carCount;
    private InputRoundCount roundCount;
    private List<Car> cars;

    public RacingGame(InputCarCount carCount, InputRoundCount roundCount) {
        if (carCount == null || roundCount == null) {
            throw new IllegalArgumentException();
        }

        this.carCount = carCount;
        this.roundCount = roundCount;
        this.cars = new ArrayList<>();

        for (int i = 0; i < carCount.getCarCount(); i++) {
            this.cars.add(new Car());
        }
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public int play() {
        int tryCount = 0;
        for (int i = 0; i < roundCount.getRoundCount(); i++) {
            cars.forEach(car -> car.stopOrGo(ConditionGenerator.getInstance().generateRandomCondition()));
            if (tryCount == 0) {
                System.out.println(MESSAGE_RESULT);
            }
            ResultView.renderResultView(cars);
            tryCount++;
        }
        return tryCount;
    }
}
