package racing.domain;

import racing.util.NumberGenerator;

public class Car {

    private int position;

    private Car(int position) {
        this.position = position;
    }

    public int getCurrentPosition() {
        return position;
    }

    public void move(NumberGenerator numberGenerator) {
        if (isMovable(numberGenerator)) {
            position++;
        }
    }

    private boolean isMovable(NumberGenerator numberGenerator) {
        int randomNumber = numberGenerator.generate();
        return randomNumber >= 4;
    }

    public static Car createCar() {
        return new Car(0);
    }
}
