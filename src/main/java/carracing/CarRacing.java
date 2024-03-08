package carracing;

import static carracing.InputView.*;

public class CarRacing {
    public static void main(String[] args) {
        try {
            int enteredNumberOfCars = enteredNumber(NUMBER_OF_CARS_INPUT_GUIDE_MESSAGE);
            int enteredNumberOfAttempts = enteredNumber(NUMBER_OF_ATTEMPTS_INPUT_GUIDE_MESSAGE);

        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
