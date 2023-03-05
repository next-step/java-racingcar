package RacingCar;

import java.util.Random;

public class Car {
    String name;
    int move;

    public Car(String n, int num) {
        name = n;
        move = num;
    }

    public void Move() {
        Random random = new Random();
        if(random.nextInt(9) > 4)
            this.move += 1;
    }

}
