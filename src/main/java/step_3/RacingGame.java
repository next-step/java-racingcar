package step_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGame {
    private final int enterCars;
    private final int executionCount;
    private final List<RacingResult> lapHistory;

    private RacingGame(Integer enterCars, Integer executionCount) {
        this.enterCars = enterCars;
        this.executionCount = executionCount;
        this.lapHistory = new ArrayList<>();
    }

    public List<RacingResult> startRacing() {
        RacingResult racingResult = standby();
        while (!racingResult.complete()) {
            racingResult = run(racingResult.gameStatus());
        }
        return lapHistory;
    }

    public RacingResult standby () {
        this.lapHistory.add(new RacingResult.Builder()
                .carsOnLap(IntStream.range(0, enterCars).mapToObj(operand -> 0).collect(Collectors.toList()))
                .complete(this.executionCount <= this.lapHistory.size())
                .build());
        return this.lapHistory.get(this.lapHistory.size() - 1);
    }

    public RacingResult run(List<Integer> carsOnCourse) {
        this.lapHistory.add(new RacingResult.Builder()
                .carsOnLap(goAheadCars(carsOnCourse))
                .complete(this.executionCount <= this.lapHistory.size())
                .build());
        return this.lapHistory.get(this.lapHistory.size() - 1);
    }

    public List<RacingResult> finalRacingData() {
        return this.lapHistory;
    }

    private List<Integer> goAheadCars(List<Integer> cars) {
        return cars.stream()
                .mapToInt(value -> goAhead() ? value + 1 : value)
                .boxed()
                .collect(Collectors.toList());
    }

    private boolean goAhead() {
        return new Random().nextInt(9) >= 4;
    }


    public static class Builder {
        private Integer enterCars;
        private Integer executionCount;

        public Builder enterCars(Integer enterCars) {
            this.enterCars = enterCars;
            return this;
        }

        public Builder execution(Integer executionCount) {
            this.executionCount = executionCount;
            return this;
        }

        public RacingGame build() {
            return new RacingGame(this.enterCars, this.executionCount);
        }
    }
}
