package step3;

import java.util.Random;

public class Referee {
    public void judge(Car car) {
        if (canMoveCar()) {
            car.move();
        }
    }

    private boolean canMoveCar() {
        Random random = new Random();
        int standard = random.nextInt(10);
        return standard <= 4;
    }



}
