package step3.application.domain;

import step3.application.domain.model.OneMoveRecord;
import step3.application.domain.model.RacingHistory;
import step3.application.generator.NumberRandomGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Racing {

    private final RacingCars racingCars;

    public Racing(int carCount) {
        validateCount(carCount);
        this.racingCars = new RacingCars(createRacingGroup(carCount), new NumberRandomGenerator());
    }

    private List<Car> createRacingGroup(int carCount) {
        return IntStream.rangeClosed(1, carCount)
                .mapToObj(Car::new)
                .collect(Collectors.toList());
    }

    public RacingHistory startRace(int moveCount) {
        validateCount(moveCount);
        return new RacingHistory(doRace(moveCount));
    }

    private List<OneMoveRecord> doRace(int count) {
        return IntStream.rangeClosed(1, count)
                .mapToObj(i -> racingCars.moveCars())
                .collect(Collectors.toList());
    }

    private static void validateCount(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("잘못된 값이 입력되었습니다.");
        }
    }
}
