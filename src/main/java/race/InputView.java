package race;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String CAR_NAME_DELIMITER = ",";

    public static RaceInput getRaceInput() {
        List<String> parsedCarNames = getCarNamesInput();
        int gameCount = getGameCountInput();

        return new RaceInput(gameCount, parsedCarNames);
    }

    private static List<String> getCarNamesInput() {
        List<String> parsedCarNames = new ArrayList<>();
        String carNames = "";

        while (true) {
            try {
                carNames = inputCarName();
                parsedCarNames = parseCarNames(carNames);
                InputValidator.validateCarNames(parsedCarNames);
                break;
            } catch (InvalidInputException e) {
                ResultView.printErrorMessage(e);
            }
        }

        return parsedCarNames;
    }

    private static int getGameCountInput() {
        int gameCount = 0;

        while (true) {
            try {
                gameCount = inputGameCount();
                InputValidator.validateGameCount(gameCount);
                break;
            } catch (InvalidInputException e) {
                ResultView.printErrorMessage(e);
            }
        }

        return gameCount;
    }

    private static String inputCarName() {
        ResultView.printCarNamesRequestMessage();
        return getInputString();
    }

    private static int inputGameCount() {
        ResultView.printGameCountRequestMessage();
        return getInputInteger();
    }

    private static List<String> parseCarNames(String carNames) {
        return Arrays.asList(carNames.split(CAR_NAME_DELIMITER));
    }

    private static int getInputInteger() {
        try {
            Scanner scanner = new Scanner(System.in);
            return scanner.nextInt();
        } catch (Exception e) {
            return 0;
        }
    }

    private static String getInputString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}
