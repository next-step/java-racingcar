package racingcar;

import java.util.Random;

public class Car {
    String distance = "-";
    Random random = new Random();

    public void go(){
        int speed = random.nextInt(10);
        if(speed >= 4){
            distance+="-";
        }
    }

    public String getDistance() {
        return distance;
    }
}
