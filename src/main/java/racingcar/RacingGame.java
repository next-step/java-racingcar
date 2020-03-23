package racingcar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RacingGame {

    // 각 Car들의 시작 위치
    public static final int BASE_POSITION = 1;

    // 랜덤값이 해당 값 이상일때만 move
    private static final int MORE_THAN_VALUE_FOR_CAR_MOVE = 4;

    // 자동차 이름 구분자
    private final static String SEPARATOR_CAR_NAMES = ",";

    private List<Car> cars;
    private RandomValueGeneratable randomValueGenerator;

    public RacingGame(String carNames) {
        this(carNames, getRandomValueGenerator());
    }

    public RacingGame(String carNames, RandomValueGeneratable randomValueGenerator) {
        validateCarNames(carNames);
        makeCars(carNames);
        this.randomValueGenerator = randomValueGenerator;
    }

    public void startRacing(int runCount) {
        validateInputCount(runCount);
        for (int i = 0; i < runCount; i++) {
            moveCar();
        }
    }

    public List<Car> getWinners(List<Car> cars) {
        int maxPosition = getBestPosition(cars);

        return cars.stream()
                .filter(c -> c.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private int getBestPosition(List<Car> cars) {
        return cars.stream()
                .max(Comparator.comparing(Car::getPosition))
                .get().getPosition();
    }

    public List<Car> getCurrentCars() {
        List<Car> cloneCars = new ArrayList<>();

        for (int i = 0; i < this.cars.size(); i++) {
            cloneCars.add(this.cars.get(i).clone());
        }
        return cloneCars;
    }

    private void moveCar() {
        for (int i = 0; i < this.cars.size(); i++) {
            if (randomValueGenerator.getRandomValue() > MORE_THAN_VALUE_FOR_CAR_MOVE) {
                this.cars.get(i).move(1);
            }
        }
    }

    private void makeCars(String carNames) {
        this.cars = new ArrayList<>();

        String[] splitCarNames = carNames.split(SEPARATOR_CAR_NAMES);
        for (int i = 0; i < splitCarNames.length; i++) {
            this.cars.add(new Car(splitCarNames[i], BASE_POSITION));
        }
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

    private static RandomValueGeneratable getRandomValueGenerator() {
        RandomValueGeneratable randomValueGeneratable = () -> {
            Random random = new Random();
            return random.nextInt(10);
        };
        return randomValueGeneratable;
    }
}
