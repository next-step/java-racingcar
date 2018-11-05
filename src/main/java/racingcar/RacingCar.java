package racingcar;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class RacingCar {
    private static final int START_POSITION = 1;
    private int position;

    private RacingCar(int position) {
        this.position = position;
    }

    public static List<RacingCar> create(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> create())
                .collect(toList());
    }

    public static RacingCar create() {
        return new RacingCar(START_POSITION);
    }

    public void move(RacingCarAccelerator accelerator) {
        this.move(accelerator.stepOn(position));
    }

    private void move(int count) {
        IntStream.range(0, count)
                .forEach(i -> this.move());
    }

    private void move() {
        this.position = position + 1;
    }

    public int getPosition() {
        return position;
    }
}
