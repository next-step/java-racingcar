package racinggame;

import java.util.Random;

public class RacingGame {

    private int[] carPositions;

    private RacingGameConfiguration configuration;

    public RacingGame(RacingGameConfiguration configuration) {
        this.configuration = configuration;
    }

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(InputView.getConfiguration());
        racingGame.initializeCarPositions();

        CarAdvanceProcessor processor = new CarAdvanceProcessor(new Random());
        ResultView resultView = new ResultView();

        for( int i = 0, numberOfTries = racingGame.configuration.getNumberOfTries(); i < numberOfTries; ++i ) {
            processor.moveForward(racingGame.carPositions);
            resultView.showCarPositions(racingGame.carPositions);
        }
    }

    private void initializeCarPositions() {

        carPositions = new int[configuration.getNumberOfCars()];

        for( int i = 0, length = carPositions.length; i < length; ++i ) {
            carPositions[i] = 1;
        }
    }
}