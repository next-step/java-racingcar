package carRacing;


import java.util.Random;

public class Car implements Vehicle {

    Random random;
    int position;

    public Car() {
        random = new Random();
        this.position = 0;
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.movable()) {
            position++;
        }
    }

    public int inquiryPosition() {
        return position;
    }
}
