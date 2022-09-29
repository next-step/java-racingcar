package carRacing;

public class Car {
    private final String name;
    private int position = 1;

    private static final int BASIS_POINT_TO_MOVE = 4;
    private static final int LIMIT_LENGTH_TO_CAR_NAME = 5;

    Car(String name) {
        if (!isValidName(name)) {
            throw new RuntimeException("lengthToCarName must less than 6  : " + name);
        }

        this.name = name;
    }

    public void run(int movePoint) {
        if (isMovable(movePoint)) {
            this.position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return this.position;
    }

    private boolean isMovable(int movePoint) {
        return movePoint >= BASIS_POINT_TO_MOVE;
    }

    private boolean isValidName(String name) {
        return name != null && name.length() <= LIMIT_LENGTH_TO_CAR_NAME;
    }

}
