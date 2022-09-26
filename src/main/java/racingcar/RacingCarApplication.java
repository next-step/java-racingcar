package racingcar;

import racingcar.util.ConvertUtil;
import racingcar.view.InputView;
import racingcar.view.QuestionView;
import racingcar.view.ResultView;

public class RacingCarApplication {

    public static void main(String[] args) {
        String carNums = InputView.askQuestion(QuestionView.QUESTION_CAR_NUMS);
        String tryNums = InputView.askQuestion(QuestionView.QUESTION_TRY_NUMS);
        RacingGame racingCar = new RacingGame(ConvertUtil.toInt(carNums), ConvertUtil.toInt(tryNums));
        RacingRecord racingRecord = racingCar.racingStart();
        ResultView.printRoundRecord(racingRecord, "-");
    }

}
