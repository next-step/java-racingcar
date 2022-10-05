package step3;

import java.util.Random;


public class Car {
    private int distance;
    private final int CAR_MOVE = 1;

    public Car(int distance) {
        this.distance = distance;
    }
    public void move(int speed) {
        if(speed >= 4){
            distance += CAR_MOVE; //전진
        }
    }
    public int getDistance() {
        return distance;
    }

}
