package racing;

import java.util.Random;

public class Car {
    private String name = "";
    private int speed = 0;
    final int min = 1;
    final int max = 10;
    int winCount = 0;
    Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        Random random = new Random();
        this.speed = random.nextInt(max + min) + min;

        if (speed > 3) {
            racingPrint();
        }
        return this.speed;
    }

    void racingPrint() {
        for (int speedIdx = 0; speedIdx < this.speed; speedIdx++) {
            System.out.print("-");
        }
    }
    void setWinner() {
        winCount = winCount + 1;
    }
}
