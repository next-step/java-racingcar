package carracing.domain;

import java.util.Random;

public class Car {

    private int position = 0;
    private String carName;

    public Car(String carName) {
        this.carName = carName;
    }

    public int getPower() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public void setPosition(CarCondition carCondition) {
        if(carCondition.isMovable()) {
            position++;
        }
        return;
    }

    public int getPosition() {
        return position;
    }

    public String getCarName() {
        return carName;
    }

}