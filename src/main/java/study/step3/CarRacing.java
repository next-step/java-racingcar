package study.step3;

import java.util.*;

public class CarRacing {
    private static boolean isSuccess() {
        final Random random = new Random();
        int randomNumber = random.nextInt(10);

        return randomNumber >= 4;
    }
}
