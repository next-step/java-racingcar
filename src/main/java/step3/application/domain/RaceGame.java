package step3.application.domain;

import step3.application.domain.model.dto.OneMovementLog;
import step3.application.domain.model.dto.RaceGameLog;
import step3.application.generator.MovableGenerator;
import step3.application.generator.MovableRandomGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RaceGame {

    private final RacingCars racingCars;

    public RaceGame(RacingCars racingCars) {
        this.racingCars = racingCars;
    }

    public RaceGame(List<String> carNames) {
        this.racingCars = new RacingCars(createRacingGroup(carNames), new MovableRandomGenerator());
    }

    public RaceGame(List<Car> cars, MovableGenerator movableGenerator) {
        this(new RacingCars(cars, movableGenerator));
    }

    private List<Car> createRacingGroup(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public RaceGameLog startRace(int moveCount) {
        validateCount(moveCount);
        return new RaceGameLog(doRace(moveCount));
    }

    private List<OneMovementLog> doRace(int count) {
        return IntStream.rangeClosed(1, count)
                .mapToObj(i -> racingCars.moveCars())
                .collect(Collectors.toList());
    }

    private void validateCount(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("잘못된 값이 입력되었습니다.");
        }
    }
}
