package racingcar;

import racingcar.domain.PositiveNumber;
import racingcar.domain.RacingFacilitator;
import racingcar.dto.StageRecord;
import racingcar.utils.InputView;
import racingcar.utils.OutputView;

import java.util.List;

public class RacingCarApplication {

    public static void main(String[] args) {

        InputView.questionsByText("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        List<String> carNames = InputView.inputString();

        InputView.questionsByText("시도할 회수는 몇 회 인가요?");
        PositiveNumber trySize = InputView.inputNumber();

        RacingFacilitator facilitator = RacingFacilitator.participate(trySize, carNames);
        List<StageRecord> stageRecords = facilitator.processRacing();

        OutputView.outputText("실행 결과");
        OutputView.outputStageRecords(stageRecords);
        OutputView.outputText(facilitator.getWinners() + "가 최종 우승했습니다.");
    }
}
