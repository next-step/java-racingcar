package racingcar.view;

import java.util.Scanner;

import static racingcar.Constants.*;

public class InputView {
    static Scanner scanner = new Scanner(System.in);
    private static int carCounts;
    private static int racingCounts;

    public static int getCarCounts() {
        System.out.println(ASK_CAR_COUNT);
        return carCounts = scanner.nextInt( );
    }

    public static int getRacingCounts() {
        System.out.println(ASK_RACING_COUNT);
        return racingCounts = scanner.nextInt( );
    }
}

