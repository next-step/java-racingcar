package Step3;

import java.util.Random;

public class RandGenerator {
    public static int[][] genPlayRands(int carNum, int playNum) {
        Random rand = new Random();
        int[][] playRands = new int[playNum][carNum];

        for (int i = 0; i < playNum; i++) {
            playRands[i] = genCarRands(carNum, rand);
        }

        return playRands;
    }

    private static int[] genCarRands(int carNum, Random rand) {
        int[] carRands = new int[carNum];

        for (int i = 0; i < carNum; i++) {
            carRands[i] = rand.nextInt(10);
        }

        return carRands;
    }
}
