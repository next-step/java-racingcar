package racingcar;

import resource.StringResources;

import java.util.Scanner;

public class InputView {

    private final int numberOfCars;
    private final int tryCount;

    public InputView() {

        Scanner scanner = new Scanner(System.in);

        System.out.println(StringResources.ASK_NUMBER_OF_CARS);
        numberOfCars = scanner.nextInt();

        System.out.println(StringResources.ASK_TRY_COUNT);
        tryCount = scanner.nextInt();
    }

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public int getTryCount() {
        return tryCount;
    }
}
