package race;

import java.util.Random;

public class CarRaceGameRule {
    public static boolean checkMove(Random random) {
        return random.nextInt(10) >= 4;
    }
}
