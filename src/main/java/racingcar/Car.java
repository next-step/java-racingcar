package racingcar;

import java.util.Random;

public class Car {
    private int mPosition;
    static Random random = new Random(4);

    public Car()
    {
        mPosition = 0;
    }

    public int position() {
        return mPosition;
    }

    public void updatePosition() {
        int randomValue = random.nextInt(10);
        if (randomValue >= 4){
            mPosition++;
        }
    }
}
