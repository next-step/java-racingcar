package racingcar;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    private static final int CHECK_CAR_COUNT = 0;
    private static final String CARS_DELIMITER = ",";
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

    public boolean checkSize() {
        return cars.size() > CHECK_CAR_COUNT;
    }

    public List<Car> getCopyCarList() {
        List<Car> copyCarList = new ArrayList<>();
        for(Car car : cars) {
            copyCarList.add(new Car(car.carName(), car.position()));
        }
        return copyCarList;
    }

    public boolean checkSizeFromInput(int checkSize) {
        return cars.size() == checkSize;
    }

    private String[] splitCarsName(String carsName) {
        if(validateCarsName(carsName)) {
            return carsName.split(CARS_DELIMITER);
        }
        throw new IllegalArgumentException("자동차 이름 처리 간 문제가 발생 하였습니다.");
    }

    private List<String> toStringList(String[] carsName) {
        return Arrays.stream(carsName)
                .collect(Collectors.toList());
    }

    private boolean validateCarsName(String carsName) {
        return carsName != null && ! carsName.isBlank() && carsName.length() > 0;
    }

    public void addMove() {
        cars.forEach(car ->
                car.move(raceCondition.generateCondition()));
    }

    public List<String> convertPositionToExpression(String carNameColon, String expression) {
        List<String> moveStates = new ArrayList<>();
        for (Car car : cars) {
            moveStates.add(car.carExpression(carNameColon, expression));
        }
        return moveStates;
    }

    private Car findRaceWinner() {
        if (checkSize()) {
            cars.sort(Comparator.reverseOrder());
            return cars.get(FIRST_INDEX);
        }
        throw new IllegalArgumentException("Car List 에는 한건 이상의 데이터가 있어야 합니다.");
    }

    private List<Car> makeRaceWinners() {
        Car winner = findRaceWinner();
        return cars.stream()
                .filter(car -> car.isEqualPosition(winner))
                .collect(Collectors.toList());
    }

    public String getWinners() {
        List<String> winners = makeRaceWinners().stream()
                .map(Car::carName)
                .collect(Collectors.toList());

        return String.join(CARS_DELIMITER, winners);
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
