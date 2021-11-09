package carracing;

import java.util.Random;

/*
 * ResultView
 *
 * Version 1.0.0
 *
 * 2021-11-08
 *
 * author jiseok-choi
 */
public class ResultView {

    private final String[] racingCar;

    private static final int RANDOM_RANGE = 10;
    private static final String RACING_INIT = "";
    private static final String MOVED = "-";

    public ResultView(int carCount) {

        racingCar = new String[carCount];
    }

    public void racing() {
        Random random;
        for (int i = 0; i < racingCar.length; i++) {
            random = new Random();
            int randomNum = random.nextInt(RANDOM_RANGE);

            if (racingCar[i] == null) {
                racingCar[i] = RACING_INIT;
            }

            if (randomNum > 4) {
                racingCar[i] = racingCar[i] + MOVED;
            }
        }
    }

    public void printRacing() {
        System.out.println();
        for (String s : racingCar) {
            System.out.println(s);
        }
    }

}
