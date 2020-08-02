package racingcar;

import resource.StringResources;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static RacingData input() {

        System.out.println(StringResources.ASK_NUMBER_OF_CARS);
        int numberOfCars = scanner.nextInt();

        System.out.println(StringResources.ASK_TRY_COUNT);
        int tryCount = scanner.nextInt();

        return new RacingData(numberOfCars, tryCount);
    }
}
