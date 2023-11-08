package step3;

import java.io.IOException;

public class CarRacingView {
    
    public static void main(String[] args) throws IOException {
        CarRacing carRacing = new CarRacing();
        RacingInputView input = new RacingInputView(carRacing);

        input.inputNumOfCars();
        input.inputNumOfTry();
    }
}
