package RacingCar;

public class Car {
    private int position;
    private int STANDARD_TO_MOVE_NUMBER = 4;

    public Car() {
        this.position = 1;
    }

    public void move(int input) {
        if (input >= STANDARD_TO_MOVE_NUMBER) {
            position += 1;
        }
    }

    public int getPosition() {
        return position;
    }
}
