package racing.module;

import java.util.Random;

public class Car {
    private int position = 0;
    private static final Random RANDOM = new Random();

    public Car(int position) {
        this.position = position;
    }

    public void move() {
        int speed = RANDOM.nextInt(10);
        if (speed >= 4) {
            position += speed;
        }
    }

    public void printPosition() {
        System.out.print("#"); // 출발선
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.print("\n");
    }
}
