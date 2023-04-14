package entity.race;

import entity.car.Car;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingCars {

    private static final int MAX_CAR_NAME_LENGTH = 5;
    private final List<Car> cars;

    private RacingCars(List<Car> racingCars) {
        this.cars = racingCars;
    }

    public static RacingCars of(int numberOfCar, String carNames) {
        validateNumberOfCar(numberOfCar);
        validateCarNames(numberOfCar, carNames);

        String[] carName = carNames.split(",");
        List<Car> cars = IntStream.range(0, numberOfCar)
                .mapToObj(i -> new Car(carName[i % carName.length]))
                .collect(Collectors.toList());

        return new RacingCars(cars);
    }

    public List<String> getHeadOfRace() {

        Comparator<Car> comparatorByAge = Comparator.comparingInt(Car::getPositionValue);

        Car max = cars.stream().max(comparatorByAge).orElse(null);

        List<String> names = cars.stream()
                .filter(car -> car.getPositionValue() == max.getPositionValue())
                .map(Car::getNameValue)
                .collect(Collectors.toList());

        return names;
    }

    private static void validateNumberOfCar(int numberOfCar) {
        if (numberOfCar <= 0) {
            throw new IllegalArgumentException("레이스 차는 1대 이상 이어야 합니다.");
        }
    }

    private static void validateCarNames(int numberOfCar, String carNames) {
        checkNullOrBlank(carNames);
        checkSameCountOfCars(numberOfCar, carNames);
        checkDuplicateName(carNames);
        checkLengthOfCarName(carNames);

    }

    private static void checkLengthOfCarName(String carNames) {
        String[] carName = carNames.split(",");
        Arrays.stream(carName).forEach(str -> {
            if (str.length() > MAX_CAR_NAME_LENGTH)
                throw new IllegalArgumentException("차량 이름은 5글자를 초과 할 수 없습니다.");
        });
    }

    private static void checkDuplicateName(String carNames) {
        String[] carName = carNames.split(",");
        Set<String> set = new HashSet<>(Arrays.asList(carName));
        if (set.size() != carName.length) {
            throw new IllegalArgumentException("차량 이름이 중복 됩니다.");
        }
    }

    private static void checkSameCountOfCars(int numberOfCar, String carNames) {
        int countOfName = carNames.split(",").length;
        if (numberOfCar != countOfName) {
            throw new IllegalArgumentException("입력된 이름과 차량 갯수가 맞지 않습니다.");
        }
    }

    private static void checkNullOrBlank(String carNames) {
        if (carNames == null || carNames.isBlank()) {
            throw new IllegalArgumentException("자동차 이름이 null 이거나 빈 칸입니다.");
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
