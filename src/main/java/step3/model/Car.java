package step3.model;

import java.util.Random;

public class Car {

    private static final String MOVE = "-";

    private String movingDistance = "";

    public void move(int number) {
       if (number >= 4) {
           movingDistance += MOVE;
       }
    }

    public String getMovingDistance() {
        return movingDistance;
    }

}
