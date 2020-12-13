package racing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static racing.common.Verify.checkArgument;
import static racing.domain.CarRacingProperty.MAX_RANDOM_NUMBER;
import static racing.domain.CarRacingProperty.MIN_RANDOM_NUMBER;

public class CarRacing {

    private static final String RACE_COUNT_ERROR_MESSAGE = "The races must be at least 1";

    private final Cars cars;
    private final MoveStrategy moveStrategy;
    private final int raceCount;

    public CarRacing(String carNames, int raceCount) {
        this(carNames, new RandomMoveStrategy(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER), raceCount);
    }

    public CarRacing(String carNames, MoveStrategy moveStrategy, int raceCount) {
        checkArgument(raceCount > 0, RACE_COUNT_ERROR_MESSAGE);
        this.cars = new Cars(carNames);
        this.moveStrategy = moveStrategy;
        this.raceCount = raceCount;
    }

    public void race(Consumer<CarContext> carConsumer, Runnable roundEnded) {
        for (int i = 0; i < raceCount; i++) {
            cars.moveAll(moveStrategy);
            cars.iterateCar(carConsumer);
            roundEnded.run();
        }
    }

    public String[] getWinnerCarNames() {
        int maxMovedDistance = cars.getMaxMovedDistance();
        List<String> winners = new ArrayList<>();
        cars.iterateCar(carContext -> addWinnerCar(winners, carContext, maxMovedDistance));
        return winners.toArray(new String[0]);
    }

    private void addWinnerCar(List<String> winners, CarContext carContext, int maxMovedDistance) {
        if (carContext.getMovedDistance() == maxMovedDistance) {
            winners.add(carContext.getName());
        }
    }
}
