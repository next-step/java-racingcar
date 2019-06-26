package step4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static step4.ValidationCheck.*;

public class RacingGameWinner {

    private static final int STRAIGHT = 4;
    private static final int GO = 1;
    private static final int STOP = 0;

    protected List<Integer> carPositions = new ArrayList<>();
    private Random random = new Random();

    void setInitPosition(int carNumber) {
        for (int i = 0; i < carNumber; i++) {
            carPositions.add(i, 0);
        }
        checkCarNumber(carNumber, carPositions.size());
    }

    void startRacing(int carNumber) {
        for (int i = 0; i < carNumber; i++) {
            carPositions.set(i, carPositions.get(i) + move());
        }
    }

    private int move() {
        int randomNum = random.nextInt(10);
        checkRandomValue(randomNum);

        if (randomNum >= STRAIGHT) {
            checkGo(randomNum);
            return GO;
        }
        return STOP;
    }
}