package racingcar.domain;

public class RacingCar {

    private static final int STARTING_POSITION = 0;
    private static final int MINIMUM_VALUE_TO_MOVE = 4;

    private int carPosition;
    private String name;

    public RacingCar(String name) {
        this.name = name;
        this.carPosition = STARTING_POSITION;
    }

    public RacingCar(String name, int carPosition) {
        this.name = name;
        this.carPosition = carPosition;
    }

    public void action(int value) {
        if (value >= MINIMUM_VALUE_TO_MOVE) {
            this.move();
        }
    }

    private void move() {
        this.carPosition++;
    }


    public int getCarPosition() {
        return this.carPosition;
    }

    public String getName() {
        return this.name;
    }
}