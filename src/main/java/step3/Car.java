package step3;

public class Car {
    public static final int MIN_MOVEMENT_THRESHOLD = 4;
    public static final String GO = "-";
    public static final String STOP = "";

    private String position = "";

    public String getPosition() {
        return position;
    }

    void updatePosition(String movementStatus) {
        if (movementStatus.equals(GO)) {
            position += movementStatus;
        }
    }

    public String getMovementStatus(int randomNumber) {
        if (randomNumber >= MIN_MOVEMENT_THRESHOLD) {
            return GO;
        }

        return STOP;
    }
}

