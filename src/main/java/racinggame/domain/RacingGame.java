package racinggame.domain;

import racinggame.utils.RandomValueGenerator;
import racinggame.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private static final int MAX_BOUND = 10;

    private List<Car> cars;
    private int tryNo;

    public RacingGame(String carNames, int tryNo) {
        if (StringUtils.isBlank(carNames)) {
            throw new IllegalArgumentException("사용자 이름은 빈 값이 될 수 없습니다.");
        }
        this.cars = createCars(carNames);
        this.tryNo = tryNo;
    }

    private static List<Car> createCars(String inputNames) {
        List<Car> cars = new ArrayList<>();
        String[] names = inputNames.split(",");
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public RacingResult race() {
        this.tryNo--;
        racingPerTry();
        return new RacingResult(cars);
    }

    private void racingPerTry() {
        for (Car car: cars) {
            car.move(RandomValueGenerator.nextInt(MAX_BOUND));
        }
    }

    public boolean isEnd() {
        return this.tryNo == 0;
    }
}
