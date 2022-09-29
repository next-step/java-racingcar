package racingcar;

import racingcar.strategy.RandomStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCarApplication {

    public static final int FORWARD_CONDITION_LOW_BOUND = 4;
    public static final int FORWARD_CONDITION_HIGH_BOUND = 9;

    public static void main(String[] args) {
        int carNums = InputView.askQuestionAnswerInt("자동차 대수는 몇 대 인가요?");
        int tryNums = InputView.askQuestionAnswerInt("시도할 횟수는 몇 회 인가요?");

        RandomStrategy randomStrategy = new RandomStrategy(FORWARD_CONDITION_LOW_BOUND, FORWARD_CONDITION_HIGH_BOUND);
        RacingGame racingCar = new RacingGame(carNums, tryNums);

        RacingRecord racingRecord = racingCar.racingStart(randomStrategy);
        ResultView.printRoundRecord(racingRecord, "-");
    }
}
