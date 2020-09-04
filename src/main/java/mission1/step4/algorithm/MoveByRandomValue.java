package mission1.step4.algorithm;

import java.util.Random;

public class MoveByRandomValue implements MoveStrategy{

    @Override
    public boolean movable(int randomValue) {
        if (randomValue >= 4) {
            return true;
        }

        return false;
    }
}



