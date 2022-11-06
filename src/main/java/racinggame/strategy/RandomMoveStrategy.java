package racing;

import racing.util.RandomNumber;

import java.util.Random;

public class BasicEngine implements Engine {
    private int movableNumber = 4;

    BasicEngine() {
    }

    BasicEngine(int movableNumber) {
        this.movableNumber = movableNumber;
    }

    @Override
    public boolean canMove() {
        return RandomNumber.generate(0, 10) >= movableNumber;
    }

}
