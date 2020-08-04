package racing.domain;

import common.Verify;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

import static racing.domain.CarRacingProperty.*;

public class CarRacing {

    private static final String TRY_COUNT_ERROR_MESSAGE = "경주 시도 횟수는 1 이상이어야 합니다";
    private static final String INVALID_NAMES_ERROR_MESSAGE = "Car names input not allowed blank";
    private static final String RACE_NOT_COMPLETED_MESSAGE = "아직 레이스가 끝나지 않았습니다";

    private final int tryCount;
    private final Random random;
    private final List<Car> cars;
    private boolean complete = false;
    private int racingCount = 0;

    public CarRacing(String inputNames, int tryCount) {

        Verify.checkArgument(tryCount > 0, TRY_COUNT_ERROR_MESSAGE);
        Verify.checkArgument(StringUtils.isNotBlank(inputNames), INVALID_NAMES_ERROR_MESSAGE);

        this.tryCount = tryCount;

        random = new Random();
        cars = new ArrayList<>();

        parseInputNames(inputNames);
    }

    public void race() {
        race(null);
    }

    public void race(RaceFunction mappingFunction) {
        tryMoveCars(mappingFunction);
        racingCount++;
        complete = tryCount == racingCount;
    }

    public boolean isComplete() {
        return complete;
    }

    public int getCarCount() {
        return cars.size();
    }

    public int getRacingCount() {
        return racingCount;
    }

    public String[] getCarNames() {
        return cars.stream()
                .map(Car::getName)
                .toArray(String[]::new);
    }

    public String[] getWinners() {
        Verify.checkState(complete, RACE_NOT_COMPLETED_MESSAGE);
        return cars.stream()
                .filter(car -> car.getDistance() == getMaxMovedDistance())
                .map(Car::getName)
                .toArray(String[]::new);
    }

    public int getMaxMovedDistance() {
        return Collections.max(cars, Comparator.comparingInt(Car::getDistance)).getDistance();
    }

    public int getRandomDistance() {
        return random.nextInt(MAX_RANDOM_DISTANCE - MIN_RANDOM_DISTANCE + 1) + MIN_RANDOM_DISTANCE;
    }

    private void tryMoveCars(RaceFunction mappingFunction) {
        for (Car car : cars) {
            car.move(getRandomDistance());
            if (mappingFunction != null) {
                mappingFunction.compute(car.getName(), car.getDistance());
            }
        }
    }

    private void parseInputNames(String inputNames) {
        String[] names = inputNames.split(CAR_NAME_SEPARATOR);
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

}
