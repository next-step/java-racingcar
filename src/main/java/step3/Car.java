package step3;

import java.util.Random;


public class Car {
    private int distance;

    public Car(int distance) {
        this.distance = distance;
    }
    public void move(int speed) {
        if(speed >= 4){
            distance += 1; //전진
        }
    }
    public int speed() {
        Random random = new Random();
        return random.nextInt(10);
    }
    public int getDistance() {
        return distance;
    }

}
