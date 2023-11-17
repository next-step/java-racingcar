package camp.nextstep.edu.racingcar.view;

import camp.nextstep.edu.racingcar.domain.result.RacingGameResult;

public class RacingOutputView {

    private RacingOutputView() { }

    public static void printGameResult(RacingGameResult gameResult) {
        System.out.print("실행 결과\n" + gameResult.toString());
    }
}
