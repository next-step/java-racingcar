package racing.domain;

import common.Verify;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static racing.domain.CarRacingProperty.MAX_RANDOM_DISTANCE;
import static racing.domain.CarRacingProperty.MIN_RANDOM_DISTANCE;

public class CarRacing {

    private static final String TRY_COUNT_ERROR_MESSAGE = "경주 시도 횟수는 1 이상이어야 합니다";
    private static final String INVALID_NAMES_ERROR_MESSAGE = "Car names input not allowed blank";
    private static final String RACE_NOT_COMPLETED_MESSAGE = "아직 레이스가 끝나지 않았습니다";

    private final int tryCount;
    private final Random random;
    private boolean complete = false;
    private int racingCount = 0;
    private final Cars cars;

    public CarRacing(String inputNames, int tryCount) {

        Verify.checkArgument(tryCount > 0, TRY_COUNT_ERROR_MESSAGE);
        Verify.checkArgument(StringUtils.isNotBlank(inputNames), INVALID_NAMES_ERROR_MESSAGE);

        this.tryCount = tryCount;

        random = new Random();
        cars = new Cars(inputNames);
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

    public int getRandomDistance() {
        return random.nextInt(MAX_RANDOM_DISTANCE - MIN_RANDOM_DISTANCE + 1) + MIN_RANDOM_DISTANCE;
    }

    public String[] getWinners() {
        Verify.checkState(complete, RACE_NOT_COMPLETED_MESSAGE);

        List<String> winners = new ArrayList<>();
        cars.forEach(car -> addMaxMovedCar(winners, car));

        return winners.toArray(new String[0]);
    }

    private void addMaxMovedCar(List<String> winners, Car car) {
        if (cars.getMaxMovedDistance() == car.getDistance()) {
            winners.add(car.getName());
        }
    }

    private void tryMoveCars(RaceFunction mappingFunction) {
        cars.forEach(car -> {
            car.move(getRandomDistance());
            computeRaceFunction(car, mappingFunction);
        });
    }

    private void computeRaceFunction(Car car, RaceFunction mappingFunction) {
        if (mappingFunction != null) {
            mappingFunction.compute(car.getName(), car.getDistance());
        }
    }

}
