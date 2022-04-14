package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final int CHECK_CAR_COUNT = 0;
    private static final String CARS_DELIMITER = ",";
    private static final String CAR_NAME_COLON = " : ";
    private static final String NEW_LINE = "\n";
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

    public int getCarsSize() {
        return cars.size();
    }

    public boolean checkSize() {
        return cars.size() > CHECK_CAR_COUNT;
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

    public Cars addMove() {
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
        return cars.get(FIRST_INDEX);
    }

    public List<Car> findRaceWinners(Car winner) {
        return cars.stream()
                .filter(car -> car.isEqualPosition(winner))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        String record = "";
        for(Car car : cars) {
            record += car.carName() + CAR_NAME_COLON + car.getExpression() + NEW_LINE;
        }
        record += NEW_LINE;
        return record;
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
