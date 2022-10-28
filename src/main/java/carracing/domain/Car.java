package carracing.domain;

import java.util.Random;

public class Car {
    private static final int MOVABLE_NUMBER = 4;

    private int carId;
    private int position;

    public Car(final int carId,int position) {
        this.carId = carId;
        this.position = position;
    }

    public Car(final int carId) {
        this(carId, 0);
    }

    public int getPosition() {
        return this.position;
    }

    public void move(NumberGenerator numberGenerator) {
        int number= numberGenerator.generate();
        if(number > MOVABLE_NUMBER)
            this.position++;
    }
}
