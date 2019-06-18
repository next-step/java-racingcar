package carRacing.model;

import com.google.common.base.Strings;

public class Car {

    private final static int MOVEMENT_LIMIT_BY_OUTPUT = 4;
    private final static int MOVE = 1;
    private String name;
    private int position;

    public Car(String name) {
        if(Strings.isNullOrEmpty(name)) throw new IllegalArgumentException("");
        this.name = name;
    }

    public int move(int gamePoint) {
        if (canMove(gamePoint)) {
            position += MOVE;
        }
        return position;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    private boolean canMove(int output) {
        return MOVEMENT_LIMIT_BY_OUTPUT <= output;
    }

}
