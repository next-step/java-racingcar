package racingcar.domain;

public class Car {

    private int position;
    private String name;
    private static final int MOVE_NUMBER_CONDITION = 4;
    private static final String OUTPUT_CAR_SEPARATOR = " : ";
    private static final String OUTPUT_CAR_POSITION = "-";

    public Car(String name) {
        this.name = name;
    }

    public Car(int initPosition, String name) {
        this.position = initPosition;
        this.name = name;
    }

    public int position() {
        return position;
    }

    public String name() {
        return name;
    }

    public void move(int moveNumber) {
        if (isMoveAbleCheck(moveNumber)) {
            position++;
        }
    }

    private boolean isMoveAbleCheck(int moveNumber) {
        return moveNumber >= MOVE_NUMBER_CONDITION;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(name).append(OUTPUT_CAR_SEPARATOR);
        for (int step = 0; step < position; step++) {
            result.append(OUTPUT_CAR_POSITION);
        }
        return result.toString();
    }
}
