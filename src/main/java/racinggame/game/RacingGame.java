package racinggame.game;

import racinggame.car.Car;
import racinggame.car.Position;
import racinggame.exception.RacingGameException;
import racinggame.utils.RandomUtils;
import racinggame.utils.StringUtils;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static racinggame.exception.ErrorMessage.CAR_COUNT_REQUIREMENT_ERROR;
import static racinggame.exception.ErrorMessage.NOT_EXIST_CAR;
import static racinggame.exception.ErrorMessage.RACING_CAR_NAME_NOT_NULL;
import static racinggame.exception.ErrorMessage.ROUND_REQUIREMENT_ERROR;

public class RacingGame {

    private static final String NAME_DELIMITER = ",";
    private static final int MINIMUM_CAR_COUNT = 2;
    private static final int MINIMUM_ROUND_COUNT = 1;

    private static final int BOUND = 10;
    private static final int MOVABLE_MINIMUM_NUMBER = 4;

    private final int roundCount;
    private final List<Car> cars;

    private RacingGame(List<String> names, int roundCount) {
        validateNames(names);
        validateRoundCount(roundCount);

        this.roundCount = roundCount;
        this.cars = names.stream().map(Car::new).collect(Collectors.toList());
    }

    public static RacingGame of(String name, int roundCount) {
        if (StringUtils.isBlank(name)) {
            throw new RacingGameException(RACING_CAR_NAME_NOT_NULL);
        }

        final var names = List.of(name.split(NAME_DELIMITER));

        return new RacingGame(names, roundCount);
    }

    private void validateNames(final List<String> names) {
        if (names.size() < MINIMUM_CAR_COUNT) {
            throw new RacingGameException(CAR_COUNT_REQUIREMENT_ERROR, MINIMUM_CAR_COUNT);
        }
    }

    private void validateRoundCount(final int roundCount) {
        if (roundCount < MINIMUM_ROUND_COUNT) {
            throw new RacingGameException(ROUND_REQUIREMENT_ERROR, MINIMUM_ROUND_COUNT);
        }
    }

    public List<Round> start() {
        return IntStream.range(0, roundCount).mapToObj(i -> {
            cars.forEach(car -> car.move(this::isMovable));
            return new Round(cars);
        }).collect(Collectors.toList());
    }

    private boolean isMovable() {
        return RandomUtils.getRandomNumber(BOUND) >= MOVABLE_MINIMUM_NUMBER;
    }

    public List<Car> findWinners() {
        final var maxPosition = findMaxPosition();

        return this.cars.stream()
                .filter(car -> car.position().equals(maxPosition))
                .collect(Collectors.toList());
    }

    private Position findMaxPosition() {
        return this.cars.stream()
                .map(Car::position)
                .max(Comparator.comparing(Position::value))
                .orElseThrow(() -> new RacingGameException(NOT_EXIST_CAR));
    }

}
