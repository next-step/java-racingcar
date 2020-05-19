package step3.domain;

public class RacingCar {

    private final String name;
    private int position;

    private RacingCar(String name) {
        this.name = name;
    }

    public static RacingCar create(String name) {
        return new RacingCar(name);
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
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
}
