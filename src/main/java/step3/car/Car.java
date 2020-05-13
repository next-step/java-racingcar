package step3.car;

import step3.generator.GenerateNumberStrategy;

public class Car {

    private int position;

    private static final int MOVE_POSSIBLE_NUMBER = 4;

    public static Car of(){
        return new Car();
    }

    public int getPosition() {
        return position;
    }

    public void move(GenerateNumberStrategy numberGenerator) {
        int number = numberGenerator.generateNumber();
        this.position = number >= MOVE_POSSIBLE_NUMBER ? this.position + 1 : this.position;
    }
}
