package racing;

import java.util.Random;

public class Car {
    static String DISTANCE = "-";

    private int[] distance;
    private int round;

    public Car(int cars, int round) {
        this.distance = new int[cars];
        this.round = round;
    }

    private void move(int idx) {
        Random random = new Random();
        if (random.nextInt(10) >= 4) {
            distance[idx]++;
        }
    }

    private void distance() {
        for (int i=0; i<distance.length; i++) {
            move(i);
            ResultView.print(DISTANCE.repeat(distance[i]));
        }
        ResultView.print("");
    }

    public void race() {
        for (int i=0; i<round; i++) {
            distance();
        }
    }
}
