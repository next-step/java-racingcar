package step3.module;

import step3.domain.CarGenerator;
import step3.domain.Record;
import step3.ui.InputView;
import step3.ui.ResultView;

import java.util.List;

import static step3.util.Constants.QUESTION_HOW_MANY_CAR;
import static step3.util.Constants.QUESTION_HOW_MANY_TRY;

/**
 * 레이싱 게임 역할을 하는 클래스
 */
public class RacingGame implements RacingGameRunnable {

    public RacingGame() { }

    @Override
    public void run() {

        // 사용자의 요청 값을 입력
        InputView inputView = new InputView();
        int carCount = inputView.requestUserInput(QUESTION_HOW_MANY_CAR);
        int tryCount = inputView.requestUserInput(QUESTION_HOW_MANY_TRY);

        // 자동차 생성
        CarGenerator carGenerator = new CarGenerator(carCount);

        List<Record> record = race(carGenerator, tryCount);
        // 결과 출력
        ResultView resultView = new ResultView(record);
        resultView.result();
    }

    // 자동차 레이싱 로직
    private List<Record> race(CarGenerator carGenerator, int tryCount) {
        return null;
    }
}
