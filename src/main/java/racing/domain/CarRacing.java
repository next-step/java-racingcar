package racing.domain;

import common.Verify;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static racing.domain.CarRacingProperty.*;

public class CarRacing {

    private static final String TRY_COUNT_ERROR_MESSAGE = "경주 시도 횟수는 1 이상이어야 합니다";
    private static final String INVALID_NAMES_ERROR_MESSAGE = "Car names input not allowed blank";

    private final int tryCount;
    private final Random random;
    private final List<Car> cars;
    private boolean complete = false;
    private int racingCount = 0;
    private final CarRacingInfo racingInfo;

    public CarRacing(String inputNames, int tryCount) {

        Verify.checkArgument(tryCount > 0, TRY_COUNT_ERROR_MESSAGE);
        Verify.checkArgument(StringUtils.isNotBlank(inputNames), INVALID_NAMES_ERROR_MESSAGE);

        this.tryCount = tryCount;

        random = new Random();
        cars = new ArrayList<>();

        parseInputNames(inputNames);
        racingInfo = new CarRacingInfo(this, cars);
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

    public int getRacingCount() {
        return racingCount;
    }

    public CarRacingInfo getRacingInfo() {
        return racingInfo;
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
