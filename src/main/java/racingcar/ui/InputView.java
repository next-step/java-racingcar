package racingcar.ui;

import racingcar.common.Constants;
import racingcar.exception.NegativeNumberNotAllowedException;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int askToInsertNumberOfCars() throws Exception {
        System.out.println(Constants.ASK_NUMBER_OF_CARS);
        int numberOfCars = scanner.nextInt();

        if(numberOfCars < 0)
            throw new NegativeNumberNotAllowedException();

        return numberOfCars;
    }

    public static int askToInsertNumberOfTries() throws Exception {
        System.out.println(Constants.ASK_NUMBER_OF_TRIES);
        int numberOfTries = scanner.nextInt();

        if(numberOfTries < 0)
            throw new NegativeNumberNotAllowedException();

        return numberOfTries;
    }
}
