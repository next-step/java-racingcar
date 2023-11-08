package step3.model;

import java.util.Random;

public class Car {
  
    private Moving moving;

    public Car(Moving moving) {
        this.moving = moving;
    }

    public Moving getMoving() {
        return moving;
    }

    public void move(Integer randomNumber) {
        moving.move(randomNumber);
    }
}
