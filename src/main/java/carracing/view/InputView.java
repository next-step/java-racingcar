package carracing.view;

import carracing.model.ui.InputDto;
import carracing.util.InputUtils;

public class InputView {

    private static final String INPUT_CARS_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_TRY_COUNT = "시도할 회수는 몇회인가요?";

    private InputView() {

    }

    public static InputDto getNewCars() {
        String carsName = InputUtils.getInputString(INPUT_CARS_NAME);
        Integer tryCount = InputUtils.getInputInteger(INPUT_TRY_COUNT);

        return InputDto.of(carsName, tryCount);
    }

}
