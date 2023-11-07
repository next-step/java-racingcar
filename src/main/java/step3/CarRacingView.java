package step3;

import java.io.IOException;

public class CarRacingView {
    
    public static void main(String[] args) throws IOException {
        CarRacing carRacing = new CarRacing();
        RacingInput input = new RacingInput();
        RacingOutput output = new RacingOutput();

        output.askQuestionNumOfCars();
        input.inputNumOfCars(carRacing);

        output.askQuestionNumOfTry();
        int numOfTry = input.inputNumOfTry();

        output.printCarRacing(numOfTry, carRacing);
    }
}
