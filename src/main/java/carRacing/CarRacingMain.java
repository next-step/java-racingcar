package carRacing;


import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.stream.Collectors;


public class CarRacingMain {

    public static void main(String[] args) {
        List<String> carNames = requestInputCarName();
        int numberOfRacing = requestInputNumber(InputView.InputType.RACING);

        CarRacing racing = new CarRacing();
        Winners winners = racing.start(carNames, numberOfRacing).getWinners();
        ResultView.printWinners(winners);
    }

    static List<String> requestInputCarName() {
        List<String> namesList;

        InputView.printQuestion(InputView.InputType.NAME);

        String names = InputView.inputNames().trim();

        if (names.isEmpty()) {
            InputView.printNamesError();
            return requestInputCarName();
        }

        namesList = Arrays.stream(names.split(","))
                .map(String::trim)
                .collect(Collectors.toList());

        return namesList;
    }

    static int requestInputNumber(InputView.InputType type) {
        int number;

        InputView.printQuestion(type);

        try {
            number = InputView.inputNumber();
            if (number <= 0) {
                throw new InputMismatchException();
            }
        } catch (InputMismatchException e) {
            InputView.printNumberError();
            InputView.refreshScanner();
            number = requestInputNumber(type);
        }

        return number;
    }
}
