package racingcar;

import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCarApplication {

    public static void main(String[] args) {
        int carNums = InputView.askQuestionAnswerInt("자동차 대수는 몇 대 인가요?");
        int tryNums = InputView.askQuestionAnswerInt("시도할 횟수는 몇 회 인가요?");
        RacingGame racingCar = new RacingGame(carNums, tryNums);
        RacingRecord racingRecord = racingCar.racingStart();
        ResultView.printRoundRecord(racingRecord, "-");
    }

}
