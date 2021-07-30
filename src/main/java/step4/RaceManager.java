package step4;

import java.util.Random;
import java.util.Scanner;

public class RaceManager {
    private static final int DICE_THRETHOLD = 4;
    private static Random rd = new Random();

    public boolean judge() {
        int rdNumber = rd.nextInt(10);
        if (rdNumber >= 4) {
            return true;
        }
        return false;
    }
}
