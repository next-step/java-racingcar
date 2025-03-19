package car;

import utils.NumberGenerator;

public class Car {
    private final static int INITIAL_POSITION = 0;
    private final static int BASE_NUMBER = 4;
    private int position = INITIAL_POSITION;
    private final String name;

    public Car(String name) {
        this.name = name;
    }

    public void move(NumberGenerator numberGenerator) {
        int movableNumber = numberGenerator.generate();
        if (isAtLeastBaseNumber(movableNumber)) {
            goForward();
        }
    }

    private void goForward() {
        this.position++;
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }

    private boolean isAtLeastBaseNumber(int number) {
        return BASE_NUMBER <= number;
    }
}
