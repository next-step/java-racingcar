package racingCar;

import java.util.Random;

public class Car {
    private int position;

    public Car() {
        this.position = 0;
    }

    public int getPosition() {
        return this.position;
    }

    public void move(int dis) {
        if (checkDis(dis)) {
            this.position += dis;
        }
    }

    private boolean checkDis(int dis) {
        return dis >= 4;
    }
}
