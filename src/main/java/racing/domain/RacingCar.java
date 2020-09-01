package racing.domain;

import racing.strategy.MoveStrategy;

import java.util.Arrays;
import java.util.stream.Stream;

public class RacingCar {

    private Integer[] racingResult;
    private String nameOfCar;

    public RacingCar(String nameOfCar) {
        this.nameOfCar = nameOfCar;
    }

    public void move(int racingCount, MoveStrategy moveStrategy) {
        racingResult = Stream.generate(() -> moveStrategy.move())
                             .limit(racingCount)
                             .toArray(Integer[]::new);
    }

    public int getRacingResult(int roundOfRacing) {
        return racingResult[roundOfRacing-1];
    }

    public int getRacingResultSum(int roundOfRacing) {
        int result = 0;

        for(int i=0;i<roundOfRacing;i++) {
            result += racingResult[i];
        }

        return result;
    }

    public int getRacingResult() {

        return getRacingResultSum(racingResult.length);
    }


    @Override
    public String toString() {
        return "RacingCar{" +
                "racingResult=" + Arrays.toString(racingResult) +
                '}';
    }

    public String getName() {
        return this.nameOfCar;
    }

}
