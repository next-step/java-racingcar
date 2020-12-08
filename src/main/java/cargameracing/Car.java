package cargameracing;

import java.util.Random;

/**
 * Car Object
 * @author minji
 */
public class Car {
    private int junjin;

    public void junjinUp() {
        Random random = new Random();
        int n = random.nextInt(10);
        if (n >= 4) {
            ++junjin;
        }
    }

    public int getJunjin() {
        return junjin;
    }
}
