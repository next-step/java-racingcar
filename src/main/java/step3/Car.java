package step3;

import java.util.Random;


public class Car {
    private int distance;
    public String name;
    private final int CAR_MOVE = 1;
    private final int MINUMUN_SPEED = 4;

    public Car(int distance,String name) {
        this.distance = distance;
        this.name = name;
    }
    public void move(int speed) {
        if(speed >= MINUMUN_SPEED){
            distance += CAR_MOVE; //전진
        }
    }
    public int getDistance() {
        return distance;
    }

}
