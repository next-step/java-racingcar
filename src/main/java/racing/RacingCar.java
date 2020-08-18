package racing;

import racing.strategy.MoveStrategy;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

public class RacingCar {

    public Integer[] racingResult;
    MoveStrategy moveStrategy;

    public RacingCar() { }

    public RacingCar(MoveStrategy moveStrategy) {
       this.moveStrategy = moveStrategy;
    }

    public void startRacing(int racingCount) {
        racingResult = move(racingCount);
    }

    public Integer[] move(int racingCount) {
        return Stream.generate(() -> this.moveStrategy.move()).limit(racingCount).toArray(Integer[]::new);
    }

    public int getRacingResult(int roundOfRacing) {
        return racingResult[roundOfRacing-1];
    }

    @Override
    public String toString() {
        return "RacingCar{" +
                "racingResult=" + Arrays.toString(racingResult) +
                '}';
    }
}
