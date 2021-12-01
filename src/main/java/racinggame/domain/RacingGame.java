package racinggame.domain;

import racinggame.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private static final int MAX_BOUND = 10;

    private final Cars cars;
    private final TryNo tryNo;

    public RacingGame(String carNames, int tryNo) {
        this(carNames, new TryNo(tryNo));
    }

    public RacingGame(String carNames, TryNo tryNo) {
        this.cars = new Cars(initCars(carNames));
        this.tryNo = tryNo;
    }

    private static List<Car> initCars(String carNames) {
        if (StringUtils.isBlank(carNames)) {
            throw new IllegalArgumentException("자동차 이름은 값이 존재해야 합니다.");
        }
        String[] names = carNames.split(",");
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public void race() {
        tryNo.race();
        moveCars();
    }

    private void moveCars() {
        cars.move();
    }

    public boolean racing() {
        return tryNo.racing();
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    public List<Car> getWinners() {
        return cars.findWinners();
    }
}
