package racingcar;

import java.util.List;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCarApplication {

    public static final String COMMA_REGEX = ",";

    public static void main(String[] args) {
        String answer = InputView.askQuestionAnswer("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분");
        int tryNums = InputView.askQuestionAnswerInt("시도할 회수는 몇회인가요?");
        List<String> names = InputView.split(answer, COMMA_REGEX);

        RacingGame racingGame = new RacingGame(tryNums, names);

        RacingRecord racingRecord = racingGame.racingStart();
        ResultView.printRoundRecord(racingRecord, "-");
    }
}
