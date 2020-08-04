package racing.domain;

import common.Verify;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static racing.domain.CarRacingProperty.*;

public class CarRacing {

    private final int tryCount;
    private final Random random;
    private List<Car> cars;
    private boolean complete = false;
    private int racingCount = 0;

    public CarRacing(String inputNames, int tryCount) {

        Verify.checkArgument(tryCount > 0, "경주 시도 횟수는 1 이상이어야 합니다");
        Verify.checkArgument(StringUtils.isNotBlank(inputNames), "Car names input not allowed blank");

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

    public List<Winner> getWinners() {
        return null;
    }

    public int getRandomDistance() {
        return random.nextInt(MAX_RANDOM_DISTANCE - MIN_RANDOM_DISTANCE + 1) + MIN_RANDOM_DISTANCE;
    }

    private void tryMoveCars(RaceFunction mappingFunction) {
        for (Car car : cars) {
            car.move(getRandomDistance());
            if (mappingFunction != null) {
                mappingFunction.compute(car.getDistance());
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
