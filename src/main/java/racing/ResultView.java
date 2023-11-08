package racing;

import java.util.Arrays;
import java.util.Random;

public class ResultView {

    public static void displayRace(int[] carPositions) {
        for (int position : carPositions) {
            System.out.println("-".repeat(position));
        }
        System.out.println();
    }
}
