package step3.domain;

import java.util.Collections;

public class RacingCar {

    private static final String POSITION_INDICATOR = "-";
    private static final String POSITION_DELEMETER = "";

    private final String name;
    private int position;

    private RacingCar(String name) {
        this.name = name;
    }

    public static RacingCar create(String name) {
        return new RacingCar(name);
    }

    public int move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            this.moveCurrentPosition();
        }

        return position;
    }

    private void moveCurrentPosition() {
        this.position += 1;
    }

    @Override
    public String toString() {
        return this.name + " : " + String.join(POSITION_DELEMETER, Collections.nCopies(position, POSITION_INDICATOR));
    }
}
