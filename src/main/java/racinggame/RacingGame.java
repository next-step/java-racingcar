package racinggame;

import java.util.List;

public class RacingGame {

    private static int numberOfCars;
    private static int numberOfTries;
    private static int[] carPositions;

    public static void main(String[] args) {
        List<Integer> inputs = InputView.getInput();
        initRacingGame(inputs);

        CarAdvanceProcessor processor = new CarAdvanceProcessor();
        ResultView resultView = new ResultView();

        for( int i = 0; i < numberOfTries; ++i ) {
            processor.moveForward(carPositions);
            resultView.showCarPositions(carPositions);
        }
    }

    private static void initRacingGame(List<Integer> inputs) {

        numberOfCars = inputs.get(0);
        numberOfTries = inputs.get(1);

        carPositions = new int[numberOfCars];

        for( int i = 0, length = carPositions.length; i < length; ++i ) {
            carPositions[i] = 1;
        }
    }
}