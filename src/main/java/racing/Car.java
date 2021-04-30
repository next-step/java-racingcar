package racing;

import java.util.Random;

public class Car {
    private String name = "";
    public int count = 0;
    final int min = 1;
    final int max = 10;

    Car(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getSpeed() {
        Random random = new Random();
        int ranSpeed = random.nextInt(max + min) + min;
        if (ranSpeed > 4) {
            count = count + 1;
        }
        return this.count;
    }

}
