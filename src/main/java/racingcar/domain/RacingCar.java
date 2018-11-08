package racingcar.domain;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class RacingCar {
    private static final int START_POSITION = 1;

    private String name;
    private int position;

    private RacingCar(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static List<RacingCar> create(List<String> racingCarNames) {
        return racingCarNames.stream()
                .map(RacingCar::create)
                .collect(toList());
    }

    public static RacingCar create(String name) {
        return new RacingCar(name, START_POSITION);
    }

    public void move(RacingCarAccelerator accelerator) {
        this.move(accelerator.speedUp());
    }

    private void move(int count) {
        for (int i = 0; i < count; i++) {
            this.move();
        }
    }

    private void move() {
        this.position = position + 1;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
