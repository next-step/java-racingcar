package racingcar;

import racingcar.domain.RacingProcess;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.Collections;
import java.util.List;

public class RacingCarMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        String carNames = inputView.inputValue("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        int periodCount = Integer.parseInt(inputView.inputValue("시도할 회수는 몇 회인가요"));

        RacingProcess racingProcess = new RacingProcess(carNames, periodCount);
        List<Cars> roundResult = racingProcess.racingStart();

        ResultView resultView = new ResultView(Collections.unmodifiableList(roundResult));

        resultView.startUI();
        resultView.drawing();
        resultView.winner();
    }
}
