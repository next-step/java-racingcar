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

    private String[] carNames = {"Unknown"};
    private int roundNum = 1;
    private int currentRound = 0;

    public Race(String[] carNames, int roundNum) {
        this.carNames = carNames;
        this.roundNum = roundNum;
        checkIfValidArgumentsForRace(carNames, roundNum);

        cars = new ArrayList<>(carNames.length);
        for (int i = 0; i < carNames.length; i++) {
            this.cars.add(new Car());
        }
    }

    Race() {
        this(new String[]{""}, 1);
    }

    void checkIfValidArgumentsForRace(String[] carNames, int roundNum) throws IllegalArgumentException {
        if (!isValidCarNames(carNames) || !isValidRoundNum(roundNum)) {
            throw new IllegalArgumentException("Invalid Arguments for Race");
        }
    }

    public static boolean isValidCarNames(String[] carNames) {
        boolean result = true;
        for (String name : carNames) {
            result &= !name.trim().isEmpty();
        }

        return result;
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
