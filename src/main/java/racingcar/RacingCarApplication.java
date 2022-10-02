package racingcar;

import java.util.List;
import racingcar.strategy.RandomStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCarApplication {

    public static final int FORWARD_CONDITION_LOW_BOUND = 2;
    public static final int FORWARD_CONDITION_HIGH_BOUND = 9;

    public static final String COMMA_REGEX = ",";

    public static void main(String[] args) {
        String answer = InputView.askQuestionAnswer("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분");
        int tryNums = InputView.askQuestionAnswerInt("시도할 회수는 몇회인가요?");
        List<String> names = InputView.split(answer, COMMA_REGEX);

        RandomStrategy randomStrategy = new RandomStrategy(FORWARD_CONDITION_LOW_BOUND, FORWARD_CONDITION_HIGH_BOUND);
        RacingGame racingGame = new RacingGame(tryNums, names);

        RacingRecord racingRecord = racingGame.racingStart(randomStrategy);
        ResultView.printRoundRecord(racingRecord, "-");
    }
}
