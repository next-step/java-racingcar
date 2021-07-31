package carRacing;


import java.util.InputMismatchException;

public class CarRacingMain {

    public static void main(String[] args) {

        int numberOfCars = requestInputNumber(InputView.InputType.CAR);

        int numberOfRacing = requestInputNumber(InputView.InputType.RACING);

        CarRacing racing = new CarRacing();
        racing.start(numberOfCars, numberOfRacing);
    }

    static int requestInputNumber(InputView.InputType type) {

        int number;

        InputView.printNumberQuestion(type);

        try {
            number = InputView.inputNumber();
            if (number <= 0) {
                throw new InputMismatchException();
            }
        } catch (InputMismatchException e) {
            InputView.printError();
            number = requestInputNumber(type);
        }

        return number;
    }
}
