package domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingCar {
    private int position;

    private RacingCar() {
        this.position = 0;
    }

    public int getPosition() {
        return position;
    }

    public void moveForward() {
        this.position++;
    }

    public static List<RacingCar> createCarsByCount(int count) {
        return Stream.generate(RacingCar::new)
                .limit(count)
                .collect(Collectors.toList());
    }
}
