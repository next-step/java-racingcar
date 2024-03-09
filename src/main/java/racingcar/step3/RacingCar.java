package racingcar.step3;

import java.util.Random;

public class RacingCar {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        int carsNumber = inputView.getCarsNumbersInput();
        int roundsNumber = inputView.getRoundsNumberInput();

        RacingCarContest racingCarContest = new RacingCarContest(carsNumber, roundsNumber, new Random());

        racingCarContest.startRacingContest();
    }
}
