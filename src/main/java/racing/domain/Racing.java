package racing.domain;

import static racing.TheGame.round;
import static racing.domain.MoveCars.moveCars;

public class Racing {

    public static int racing() {
        int maxPosition = 0;

        for (int i = 0; i < round; i++) {
            maxPosition = Math.max(moveCars(), maxPosition);
            printCarPosition();
        }

        return maxPosition;
    }

    private static void printCarPosition() {
    }
}
