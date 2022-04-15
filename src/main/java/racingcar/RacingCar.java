package racingcar;

import org.jetbrains.annotations.NotNull;

import java.util.stream.IntStream;

public class RacingCar {
    public int location = 1;

    public static RacingCar @NotNull [] createBatch(int size) {
        RacingCar[] racingCars= new RacingCar[size];
        IntStream.range(0, size).forEach(i ->
                racingCars[i] = new RacingCar()
        );
        return racingCars;
    }

    public void proceed() {
        location += 1;
    }
}
