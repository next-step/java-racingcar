package edu.nextstep.camp.racing.view;

import edu.nextstep.camp.racing.domain.Cars;

public class ConsoleRacingInputView implements RacingInputView {

    @Override
    public Cars carsInput() {
        OutputView.print("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return new Cars(InputView.input().split(","));
    }

    @Override
    public int movingCountInput() {
        OutputView.print("시도할 회수는 몇회인가요?");
        return Integer.parseInt(InputView.input().trim());
    }
}
