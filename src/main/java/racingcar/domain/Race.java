package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Race {
    static final int MIN_CAR_NUM = 1;
    static final int MIN_ROUND_NUM = 1;
    static final int MAX_RANDOM_NUM = 10;
    static Random random = new Random();

    private List<Car> cars;

    private int carNum = 1;
    private int roundNum = 1;
    private int currentRound = 0;

    public Race(int carNum, int roundNum) {
        this.carNum = carNum;
        this.roundNum = roundNum;
        checkIfValidArgumentsForRace(carNum, roundNum);

        cars = new ArrayList<>(carNum);
        for (int i = 0; i < carNum; i++) {
            this.cars.add(new Car());
        }
    }

    Race() {
        this(1, 1);
    }

    void checkIfValidArgumentsForRace(int carNum, int roundNum) throws IllegalArgumentException {
        if (!isValidCarNum(carNum) || !isValidRoundNum(roundNum)) {
            throw new IllegalArgumentException("Invalid Arguments for Race");
        }
    }

    public static boolean isValidCarNum(int carNum) {
        return carNum >= MIN_CAR_NUM;
    }

    public static boolean isValidRoundNum(int roundNum) {
        return roundNum >= MIN_ROUND_NUM;
    }

    int getNumberOfCars() {
        return cars.size();
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getCurrentRound() {
        return currentRound;
    }

    public void runOneRound() {
        for (Car car : cars) {
            car.move(random.nextInt(MAX_RANDOM_NUM));
        }

        currentRound++;
    }

    public boolean isRaceOver() {
        return roundNum == currentRound;
    }
}
