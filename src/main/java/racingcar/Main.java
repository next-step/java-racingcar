package racingcar;

import racingcar.domain.Histories;
import racingcar.dto.InputCar;
import racingcar.dto.InputRoundCount;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Main {

    public static void main(String[] args) {
        InputCar inputCar = InputView.renderCarCountInputView();
        InputRoundCount inputRound = InputView.renderRoundCountInputView();

        RacingGame racingGame = new RacingGame(inputCar, inputRound);
        Histories histories = racingGame.play();

        ResultView.renderResultView(histories);
    }
}
