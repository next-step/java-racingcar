package racingcarwinner;

import racingcarwinner.view.InputView;
import racingcarwinner.view.OutputView;

import java.util.List;

public class GameMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        RacingPlay racingPlay = new RacingPlay();
        OutputView outputView = new OutputView();

        String[] carNames = inputView.carNames();
        int playCount = inputView.playCount();

        List<Car> carList = racingPlay.readyForRacing(carNames);

        System.out.println("실행 결과");
        outputView.output(carList);
        for (int i = 0; i < playCount; i++) {
            racingPlay.playRacingCar(carList);
            outputView.output(carList);
        }

        outputView.result(racingPlay.findWinner(carList));
    }
}
