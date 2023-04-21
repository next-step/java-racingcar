package step3;

import step3.view.InputView;

public class RacingCarMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        int carCount = inputView.inputValue("자동차 대수는 몇대인가요");
        int periodCount = inputView.inputValue("시도할 회수는 몇 회인가요");

        RacingProcess racingProcess = new RacingProcess(carCount, periodCount);
        racingProcess.racingStart();

    }
}
