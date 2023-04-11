package racingcar;

import racingcar.domain.CarGroup;
import racingcar.domain.Positive;
import racingcar.utils.InputView;
import racingcar.utils.OutputView;

public class RacingCarApplication {

    public static void main(String[] args) {

        InputView.questionsByText("자동차 대수는 몇 대 인가요?");
        Positive carSize = InputView.inputNumber();
        CarGroup carGroup = CarGroup.create(carSize);

        InputView.questionsByText("시도할 회수는 몇 회 인가요?");
        Positive trySize = InputView.inputNumber();

        OutputView.outputText("실행 결과");
        carGroup.moveCarsByTrySize(trySize);
    }
}
