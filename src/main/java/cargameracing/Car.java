package cargameracing;

import java.util.Random;

/**
 * Car Object
 * @author minji
 */
public class Car {
    private Name name;
    private int junjin;

    public void junjinUp(MovingStrategy MovingStrategy) {
        if (MovingStrategy.isMove()) {
            this.junjin++;
        }
    }

    public int getJunjin() {
        return junjin;
    }
}
