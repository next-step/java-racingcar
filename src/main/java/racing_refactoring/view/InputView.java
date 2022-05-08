package racing_refactoring.view;

import racing_refactoring.domain.RacingCar;
import racing_refactoring.util.InputDataUtils;
import racing_refactoring.util.RacingCarFactory;

import java.util.List;

public class InputView {
    public List<RacingCar> inputRacingCar() {
        String inputNames = InputDataUtils.scan("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return RacingCarFactory.initRacing(inputNames);
    }

    public int inputMovementCount() {
        int movementCount = InputDataUtils.scanNumber("시도할 회수는 몇 회 인가요?");
        if (movementCount < 1) {
            throw new IllegalArgumentException("시도할 회수는 1회 이상이어야 합니다.");
        }
        return movementCount;
    }
}
