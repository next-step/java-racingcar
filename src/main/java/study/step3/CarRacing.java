package study.step3;

import java.util.*;

public class CarRacing {

    private static void racing(int carNum, int tryNum) {
        String[] positionArray = new String[carNum];
        Arrays.fill(positionArray, "");

        for (int i = 0; i < tryNum; i++) {
            for (int j = 0; j < carNum; j++) {
                if (isSuccess()) {
                    positionArray[j] += "-";
                }
                System.out.println(positionArray[j]);
            }
            System.out.println();
        }
    }
    private static boolean isSuccess() {
        final Random random = new Random();
        int randomNumber = random.nextInt(10);

        return randomNumber >= 4;
    }
}
