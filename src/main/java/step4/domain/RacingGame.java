package step4.domain;

import static step4.content.ErrorMessages.DUPLICATED_CAR_NAMES_MESSAGE;
import static step4.content.ErrorMessages.INVALID_CAR_NAMES_MESSAGE;
import static step4.content.ErrorMessages.INVALID_TRY_COUNT_MESSAGE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import step4.content.Constants;
import step4.util.DistinctNameSet;
import step4.content.ErrorMessages;

public class RacingGame {

    private int tryCount;
    private ArrayList<Car> cars;
    private ArrayList<String> winners;

    public ArrayList<String> getWinners() {
        return winners;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public int getTryCount() {
        return this.tryCount;
    }

    public void goCars() {
        for (Car car : cars) {
            car.go();
        }
    }

    public void initialize(String names, int tryCount) throws IllegalArgumentException {
        validateCarNames(names);
        validateTryCount(tryCount);
        this.cars = new ArrayList<>();
        String[] carNames = parseCarNames(names);
        for (int i = 0; i < carNames.length; ++i) {
            Car car = new Car(carNames[i]);
            car.setMovableStrategy(new RandomMovableStrategy());
            this.cars.add(car);

        }
        this.tryCount = tryCount;
        this.winners = new ArrayList<>();
    }

    private void validateCarNames(String names) throws IllegalArgumentException {
        if (Objects.isNull(names)) {
            throw new IllegalArgumentException(INVALID_CAR_NAMES_MESSAGE);
        }
        String[] parsedParameter = parseCarNames(names);
        validateDuplicatedCarNames(parsedParameter);
        if (parsedParameter.length < 2) {
            throw new IllegalArgumentException(INVALID_CAR_NAMES_MESSAGE);
        }

    }

    private void validateDuplicatedCarNames(String[] names) throws IllegalArgumentException {
        DistinctNameSet distinctNameSet = new DistinctNameSet();
        for (String name : names) {
            distinctNameSet.assertDistinctName(name, DUPLICATED_CAR_NAMES_MESSAGE);
        }
    }

    public String[] parseCarNames(String names) {
        return names.split(Constants.COMMA);
    }

    private void validateTryCount(int tryCount) {
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
