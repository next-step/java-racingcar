package racing;

import racing.factories.RacingSimulatorFactory;
import racing.simulator.RacingSimulator;
import racing.utils.StringUtil;
import racing.views.IntegerInputView;
import racing.views.StringInputView;

public class RacingMain {
    public static void main(String[] args) {
        final String namesInput = new StringInputView().show("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        final int attemptsCount = new IntegerInputView().show("시도할 횟수는 몇 회인가요?");

        final RacingSimulator simulator = RacingSimulatorFactory
                .createFrom(StringUtil.splitCommas(namesInput), attemptsCount);
        simulator.start();
    }
}
