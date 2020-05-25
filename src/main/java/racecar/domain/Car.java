package racecar.domain;

import racecar.Rules;

import java.util.Random;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 1;
    }

    public static Car generate(String name){
        return new Car(name.trim());
    }

    public int move(Random random) {
        int number = random.nextInt(Rules.BOUND);
        if (number >= Rules.WIN_CONDITION)
            this.position += 1;
        return this.position;
    }

    private String makePositionStatus() {
        String status = "-".repeat(position);
        return status;
    }

    public String printStatus() {
        String result = name + " : " + makePositionStatus();
        return result;
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }
}
