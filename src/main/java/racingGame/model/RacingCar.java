package racingGame.model;

public class RacingCar {
    private static int LESS_MOVE_RANGE = 3;
    private static int GREATER_MOVE_RANGE = 11;
    private int position = 0;
    private String name;

    public RacingCar(String name) {
        this.name = name;
    }

    public int getPosition() {
        return this.position;
    }

    public void move(int gearNumber) {
        if (this.isMovable(gearNumber)) {
            this.position += 1;
        }
    }

    public String getName() {
        return this.name;
    }

    public boolean isMovable(int number) {
        return number > LESS_MOVE_RANGE && number < GREATER_MOVE_RANGE;
    }
}
