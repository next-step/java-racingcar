package step4;

import static step4.ErrorMessages.DUPLICATED_CAR_NAMES_MESSAGE;
import static step4.ErrorMessages.INVALID_CAR_NAMES_MESSAGE;
import static step4.ErrorMessages.INVALID_TRY_COUNT_MESSAGE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Random;

public class RacingGame {

    private Random random;
    private int tryCount;
    private ArrayList<Car> cars;
    private ArrayList<String> winners;

    public void setCars(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public ArrayList<String> getWinners() {
        return winners;
    }

    public void setWinners(ArrayList<String> winners) {
        this.winners = winners;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public int getTryCount() {
        return this.tryCount;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public RacingGame() {
        this.random = new Random();
    }

    public void goCars() {
        if (this.random == null) {
            this.random = new Random();
        }

        for (Car car : cars) {
            goCar(car);
        }
    }

    public void goCar(Car car) {
        if (this.random.nextInt() >= 4) {
            car.go();
        }
    }

    public void initialize(String names, int tryCount) throws IllegalArgumentException {
        validateCarNames(names);
        validateTryCount(tryCount);
        this.cars = new ArrayList<>();
        String[] carNames = parseCarNames(names);
        for (int i = 0; i < carNames.length; ++i) {
            this.cars.add(new Car(carNames[i]));
        }
        this.tryCount = tryCount;
        this.winners = new ArrayList<>();
    }

    public void validateCarNames(String names) throws IllegalArgumentException {
        if (Objects.isNull(names)) {
            throw new IllegalArgumentException(INVALID_CAR_NAMES_MESSAGE);
        }
        String[] parsedParameter = parseCarNames(names);
        validateDuplicatedCarNames(parsedParameter);
        if (parsedParameter.length < 2) {
            throw new IllegalArgumentException(INVALID_CAR_NAMES_MESSAGE);
        }

    }

    public void validateDuplicatedCarNames(String[] names) throws IllegalArgumentException {
        DistinctNameSet distinctNameSet = new DistinctNameSet();
        for (String name : names) {
            distinctNameSet.assertDistinctName(name, DUPLICATED_CAR_NAMES_MESSAGE);
        }
    }

    public String[] parseCarNames(String names) {
        return names.split(Constants.COMMA);
    }

    public void validateTryCount(int tryCount) {
        if (tryCount < 1 || tryCount > 10) {
            throw new IllegalArgumentException(INVALID_TRY_COUNT_MESSAGE);
        }
    }

    public void chooseWinners() {
        if (this.getCars() == null) {
            throw new ExceptionInInitializerError(ErrorMessages.NOT_INITIALIZE_MESSAGE);
        }

        Collections.sort(this.cars);

        int farthestPosition = -1;

        for (Car car : cars) {
            farthestPosition = chooseWinners(car, farthestPosition);
        }
    }

    private int chooseWinners(Car car, int farthestPosition) {
        if (farthestPosition <= car.getPosition()) {
            this.winners.add(car.getName());
            farthestPosition = car.getPosition();
        }
        return farthestPosition;
    }

}
