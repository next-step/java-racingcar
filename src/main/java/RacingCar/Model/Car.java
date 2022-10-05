package RacingCar.Model;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String name;
    private int position;
    private int STANDARD_TO_MOVE_NUMBER = 4;

    public Car(String name, int position) {
        carNameCheck(name);

        this.name = name;
        this.position = position;
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

    private void emptyCheck(String input) {
        if (input == null || input.isEmpty() || input.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    private void carNameCheck(String name) {
        emptyCheck(name);
        nameLengthCheck(name);
    }

    private void nameLengthCheck(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }
}
