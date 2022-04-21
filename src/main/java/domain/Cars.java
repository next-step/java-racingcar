package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final String CARS_DELIMITER = ",";
    private static final String NEW_LINE = "\n";
    private static final int CHECK_CAR_COUNT = 0;
    private static final int FIRST_INDEX = 0;
    private final List<Car> cars;
    private final RaceCondition raceCondition;

    private Cars(Builder builder) {
        this.cars = toStringList(splitCarsName(builder.carsName))
                .stream()
                .map(Car::new)
                .collect(Collectors.toList());
        this.raceCondition = builder.raceCondition;
    }

    public Cars(List<Car> cars, RaceCondition raceCondition) {
        this.cars = cars;
        this.raceCondition = raceCondition;
    }

    public static Builder builder() {
        return new Builder();
    }

    public boolean checkSize(int size) {
        return cars.size() == size;
    }

    private String[] splitCarsName(String carsName) {
        if (validateCarsName(carsName)) {
            return carsName.split(CARS_DELIMITER);
        }
        throw new IllegalArgumentException("자동차 이름 처리 간 문제가 발생 하였습니다.");
    }

    private List<String> toStringList(String[] carsName) {
        return Arrays.stream(carsName)
                .collect(Collectors.toList());
    }

    private boolean validateCarsName(String carsName) {
        return carsName != null && !carsName.isBlank() && carsName.length() > 0;
    }

    public Cars move() {
        List<Car> carList = new ArrayList<>();
        for (Car car : cars) {
            int generateCondition = raceCondition.generateCondition();
            Car copyCar = new Car(car);
            car.move(generateCondition);
            copyCar.move(generateCondition);
            carList.add(copyCar);
        }
        return new Cars(carList, raceCondition);
    }

    public void reverseSortCarsFromPosition() {
        cars.sort(Comparator.reverseOrder());
    }

    public Car getCurrentWinner() {
        if (!checkSize(CHECK_CAR_COUNT)) {
            reverseSortCarsFromPosition();
            return cars.get(FIRST_INDEX);
        }
        throw new IllegalArgumentException("Car List 에는 한건 이상의 데이터가 있어야 합니다.");
    }

    public RaceWinners findRaceWinners(Car winner) {
        return new RaceWinners(cars.stream()
                .filter(car -> car.isEqualPosition(winner))
                .collect(Collectors.toList()));
    }

    @Override
    public String toString() {
        return cars.stream()
                .map(car-> car + NEW_LINE)
                .collect(Collectors.joining());
    }

    public static class Builder {
        private String carsName;
        private RaceCondition raceCondition;

        public Builder carsName(String carsName) {
            this.carsName = carsName;
            return this;
        }

        public Builder raceCondition(RaceCondition raceCondition) {
            this.raceCondition = raceCondition;
            return this;
        }

        public Cars build() {
            return new Cars(this);
        }
    }

}
