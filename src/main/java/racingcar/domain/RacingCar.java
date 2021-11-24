package racingcar.domain;


import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RacingCar {
    private int carCount;
    private int racingCount;
    private Cars cars;

    private RacingCar(int carCount, int racingCount) {
        this.carCount = carCount;
        this.racingCount = racingCount;
        this.cars = initCars(carCount);
    }

    private RacingCar(String[] carNames, int racingCount) {
        this.carCount = carNames.length;
        this.racingCount = racingCount;
        this.cars = initCars(carNames);
    }

    public static RacingCar create(int carCount, int racingCount) {
        if (carCount < 1 || racingCount < 1) {
            throw new IllegalArgumentException("1 이상 입력해야 합니다.");
        }
        return new RacingCar(carCount, racingCount);
    }

    public static RacingCar create(String carNames, int racingCount) {
        if (carNames == null || carNames.length() == 0) {
            throw new IllegalArgumentException("자동차 이름을 입력해야 합니다.");
        }
        String[] names = carNames.split(",");
        return new RacingCar(names, racingCount);
    }

    private static Cars initCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(cars.size() + 1, new LoadMovable(), new CarName(carName)));
        }
        return new Cars(cars);
    }

    private static Cars initCars(int carCount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            int id = cars.size() + 1;
            cars.add(new Car(id, new LoadMovable(), new CarName(String.valueOf(id))));
        }
        return new Cars(cars);
    }

    public void start() {
        ResultView.println("실행결과");
        for (int i = 0; i < racingCount; i++) {
            cars.race();
            ResultView.println("");
        }
        ResultView.printWinners(cars.findWinnersString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCar racingCar = (RacingCar) o;
        return carCount == racingCar.carCount && racingCount == racingCar.racingCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(carCount, racingCount);
    }
}
