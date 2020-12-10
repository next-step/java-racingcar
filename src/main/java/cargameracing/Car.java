package cargameracing;

import java.util.Random;

/**
 * Car Object
 * @author minji
 */
public class Car {
    Random random = new Random();
    private int junjin;

    public void junjinUp() {
        int num = randomValue();
        if (num >= 4) {
            ++junjin;
        }
    }

    public int randomValue() {
        int randomNum = random.nextInt(10);
        return randomNum;
    }

    public int getJunjin() {
        return junjin;
    }
}
