package step3.application.domain;

import step3.application.domain.model.dto.RaceGameLog;
import step3.application.generator.MovableGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RaceGame {

    private final RacingCars racingCars;

    public RaceGame(List<String> names) {
        this.racingCars = new RacingCars(names);
    }

    public RaceGame(List<String> names, List<Integer> positions) {
        this.racingCars = new RacingCars(names, positions);
    }

    public RaceGameLog startRace(int moveCount, MovableGenerator movableGenerator) {
        validateCount(moveCount);
        return new RaceGameLog(IntStream.rangeClosed(1, moveCount)
                .mapToObj(num -> racingCars.doRace(movableGenerator))
                .collect(Collectors.toList())
        );
    }

    private void validateCount(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("잘못된 값이 입력되었습니다.");
        }
    }

    public int extractMaxPosition() {
        return racingCars.extractMaximumPosition();
    }

    public List<String> findBest(int maxPosition, List<String> names) {
        List<Car> bestCars = racingCars.findBestDriver(maxPosition);
        return names.stream()
                .filter(name -> bestCars.stream()
                        .anyMatch(car -> car.isBest(name))
                ).collect(Collectors.toList());
    }
}
