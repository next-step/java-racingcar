package racingcar.race;

import static racingcar.race.RacingModel.MOVE_POSSIBLE;

public class Car {
    private int position;

    private String name;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public void move(NumberGenerator numberGenerator) {
        final int number = numberGenerator.generate();

        if (number >= MOVE_POSSIBLE) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
