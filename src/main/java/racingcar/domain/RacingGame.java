package racingcar.domain;

import racingcar.domain.movable.MovableStrategy;
import racingcar.domain.movable.RandomForwardStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.view.ResultView;

public class RacingGame {

    private static final int START_FROM_ZERO = 0;

    private final MovingResult movingResult;
    private final RacingResult racingResult;
    private Cars cars;

    private RacingGame() {
        this(MovingResult.instance(), RacingResult.instance());
    }

    private RacingGame(final MovingResult movingResult,
        final RacingResult racingResult) {
        this.movingResult = movingResult;
        this.racingResult = racingResult;
    }

    public static RacingGame instance() {
        return new RacingGame();
    }

    public void drive(final int racingTime, final ResultView resultView) {
        for (int time = START_FROM_ZERO; time < racingTime; time++) {
            moveAll(resultView);
        }
    }

    private void moveAll(final ResultView resultView) {
        IntStream.range(0, cars.getCars().size())
            .forEach(idx -> {
                cars.getCars().get(idx).moveForward();
                CarStateInRace carState = new CarStateInRace(cars.getCars().get(idx));
                resultView.convertCurrentCarStatement(carState);
                movingResult.storeCurrentRoundStatement(carState);
            });
    }

    public RacingResult judgeWinners() {
        final int maxPosition = maxDriveLength();
        racingResult.registerWinners(cars.getCars().stream()
            .filter(car -> (car.getStep() == maxPosition && car.getStep() > 0))
            .map(Car::getName)
            .collect(Collectors.toList()));

        return racingResult;
    }

    private int maxDriveLength() {
        return cars.getCars().stream()
            .mapToInt(Car::getStep)
            .max()
            .getAsInt();
    }

    public void registerCars(final List<String> splitUserInput, MovableStrategy strategy) {
        cars = Cars.of(splitUserInput, strategy);
    }

    public MovingResult getMovingResult() {
        return movingResult;
    }

}
