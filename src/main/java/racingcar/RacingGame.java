package racingcar;

import racingcar.rule.MovableRuleGenerator;
import racingcar.rule.RandomMovableRule;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    // 각 Car들의 시작 위치
    public static final int BASE_POSITION = 1;

    // 한번에 움직일 거리
    private static final int BASE_MOVE_DISTANCE = 1;

    // 자동차 이름 구분자
    private final static String SEPARATOR_CAR_NAMES = ",";

    private Cars cars;
    private MovableRuleGenerator rule;
    private List<Cars> resultLogs;

    public RacingGame(String carNames) {
        this(carNames, new RandomMovableRule());
    }

    public RacingGame(String carNames, MovableRuleGenerator rule) {
        validateCarNames(carNames);
        makeCars(carNames);
        this.rule = rule;
        this.resultLogs = new ArrayList<>();
    }

    public List<Cars> startRacing(int runCount) {
        validateInputCount(runCount);
        for (int i = 0; i < runCount; i++) {
            this.cars.moveCars(BASE_MOVE_DISTANCE, this.rule);
            resultLogs.add(this.cars.getCurrentCars());
        }

        return this.resultLogs;
    }

    public Cars getCars() {
        return this.cars;
    }

    private void makeCars(String carNames) {
        List<Car> cars = new ArrayList<>();

        String[] splitCarNames = carNames.split(SEPARATOR_CAR_NAMES);
        for (int i = 0; i < splitCarNames.length; i++) {
            cars.add(new Car(splitCarNames[i], BASE_POSITION));
        }
        this.cars = new Cars(cars);
    }

    private void validateInputCount(int inputCount) {
        if (inputCount <= 0) {
            throw new IllegalArgumentException("0보다 큰 수를 입력해야 합니다.");
        }
    }

    private void validateCarNames(String carNames) {
        if (carNames.split(SEPARATOR_CAR_NAMES).length <= 1) {
            throw new IllegalArgumentException("자동차가 두대이상은 있어야 경주가 가능합니다.");
        }
    }
}
