package racingcar;

import java.util.Random;

public class Car {
    private int mPosition;

    public Car()
    {
        mPosition = 0;
    }

    public int position() {
        return mPosition;
    }

    public void updatePosition() {
        Random random = new Random(11);
        int randomValue = random.nextInt(10);
        if (randomValue >= 4){
            mPosition++;
        }
    }
}
