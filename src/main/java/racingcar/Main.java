package racingcar;

import racingcar.domain.Cars;
import racingcar.domain.RacingCar;
import racingcar.domain.Round;
import racingcar.pattern.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Main {

    public static void main(String[] args) {

        String carNames = InputView.getCarNames();
        int round =  InputView.getGameRound();


        RacingCar racingCar = new RacingCar(new Cars(carNames), new Round(round),  new RandomNumberGenerator());

        for (int currentRound = 0; currentRound < round; currentRound++) {
            racingCar.playRound();
            ResultView.printCarsPosition(racingCar);
        }
        ResultView.printWinner(racingCar.findWinners());
    }
}
