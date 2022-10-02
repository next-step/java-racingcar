package RacingCar;

public class Car {
    private String name;
    private int position;
    private int STANDARD_TO_MOVE_NUMBER = 4;

    public Car(String name) {
        this.name = name;
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

    public String getName() {
        return name;
    }
}
