package racingCar;

import racingCar.domains.Racing;
import racingCar.views.InputView;
import racingCar.views.ResultView;

public class RacingCarMain {
    public static void main(String[] args) {
        Racing racing = new Racing(InputView.askNameOfCars(), InputView.askNumberOfRounds());

        while (racing.isPlaying()) {
            racing.playRound();
            ResultView.showRoundResult(racing.getCars());
        }

        ResultView.showWinners(racing.findWinners());
    }
}
