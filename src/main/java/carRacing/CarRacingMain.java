package carRacing;


import java.util.Arrays;
import java.util.InputMismatchException;

import static carRacing.Car.NAME_MAX_LENGTH;

public class CarRacingMain {

    public static void main(String[] args) {

        String[] carNames = requestInputCarName();
        int numberOfRacing = requestInputNumber(InputView.InputType.RACING);

        CarRacing racing = new CarRacing();
        racing.start(carNames, numberOfRacing);
    }

    static String[] requestInputCarName() {
        InputView.printQuestion(InputView.InputType.NAME);

        String[] carNames = Arrays.stream(InputView.inputNames().split(","))
                .map(String::trim)
                .toArray(String[]::new);

        boolean isValidName = Arrays.stream(carNames).allMatch(s -> !s.isEmpty() && s.length() <= NAME_MAX_LENGTH);
        if (!isValidName) {
            InputView.printNamesError();
            carNames = requestInputCarName();
        }

        return carNames;
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
