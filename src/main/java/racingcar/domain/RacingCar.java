package racingcar.domain;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class RacingCar {
    private String[] carNames;
    private int racingCount;
    private Cars cars;

    private RacingCar(String[] carNames, int racingCount) {
        this.carNames = carNames;
        this.racingCount = racingCount;
        this.cars = initCars();
    }

    public static RacingCar create(String carNames, int racingCount) {
        if (carNames == null || carNames.length() == 0) {
            throw new IllegalArgumentException("자동차 이름을 입력해야 합니다.");
        }

        if (racingCount < 1) {
            throw new IllegalArgumentException("시도횟수는 1 이상 입력해야 합니다.");
        }

        String[] names = carNames.split(",");
        return new RacingCar(names, racingCount);
    }

    private Cars initCars() {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(cars.size() + 1, new LoadMovable(), new CarName(carName)));
        }
        return new Cars(cars);
    }

    public List<Car> race() {
        return cars.race();
    }

    public String findWinners() {
        return cars.findWinnersString();
    }

    public boolean isRacingCount(int currentCount) {
        return racingCount == currentCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCar racingCar = (RacingCar) o;
        return racingCount == racingCar.racingCount && Arrays.equals(carNames, racingCar.carNames);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(racingCount);
        result = 31 * result + Arrays.hashCode(carNames);
        return result;
    }
}
