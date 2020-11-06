package racingcar.ui;

import racingcar.common.Constants;
import racingcar.exception.NameTooLongException;
import racingcar.exception.NegativeNumberNotAllowedException;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final int NAME_LIMIT = 5;

    public static List<String> askToInsertCarNames() throws Exception {
        System.out.println(Constants.ASK_NAME_OF_CARS);
        List<String> carNames = Arrays.asList(scanner.nextLine().split(Constants.COMMA_DELIMITER));

        if(carNames.stream().filter(carName -> carName.length() > NAME_LIMIT).findFirst().isPresent())
            throw new NameTooLongException(Constants.NAME_TOO_LONG_ERROR);

        return carNames;
    }

    public static int askToInsertNumberOfTries() throws Exception {
        System.out.println(Constants.ASK_NUMBER_OF_TRIES);
        int numberOfTries = scanner.nextInt();

        if(numberOfTries < 0)
            throw new NegativeNumberNotAllowedException(Constants.NEGATIVE_NUMBERS_ERROR);

        return numberOfTries;
    }
}
