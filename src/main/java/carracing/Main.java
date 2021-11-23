package carracing;

import carracing.controller.CarRacing;
import carracing.exception.CarNameFormatException;

public class Main {

    public static void main(String[] args) throws CarNameFormatException {
        CarRacing carRacing = new CarRacing();
        carRacing.racingStart(carRacing.racingQuestion());
    }
}
