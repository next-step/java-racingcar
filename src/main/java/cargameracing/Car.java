package cargameracing;

import java.util.Random;

/**
 * Car Object
 * @author minji
 */
public class Car {
    private Name name;
    private int junjin;

    public Car(Name name) {
        this.name = name;
    }

    public void junjinUp(MovingStrategy MovingStrategy) {
        if (MovingStrategy.isMove()) {
            this.junjin++;
        }
    }

    public String getName() { return name.getName();};
    public int getJunjin() {
        return junjin;
    }
}
