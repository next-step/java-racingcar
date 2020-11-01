package racingcar.inputview;

import racingcar.dto.Input;

public class InputHandler {
    private static final String NUMBER_OF_CAR_QUERYING_MSG = "자동차 대수는 몇 대 인가요?";
    private static final String NUMBER_OF_COUNT_TO_TRY_QUERYING_MSG = "시도할 회수는 몇 회 인가요?";

    private final InputView inputView;
    private final InputDevice inputDevice;

    public InputHandler(InputView inputView, InputDevice inputDevice) {
        this.inputView = inputView;
        this.inputDevice = inputDevice;
    }

    public Input getInput() {
        return Input.builder()
                .numberOfCar(getNumberOfCar())
                .numberOfCountToTry(getNumberOfCountOfTry())
                .build();
    }

    private int getNumberOfCar() {
        inputView.print(NUMBER_OF_CAR_QUERYING_MSG);
        return inputDevice.getIntNumber();
    }

    private int getNumberOfCountOfTry() {
        inputView.print(NUMBER_OF_COUNT_TO_TRY_QUERYING_MSG);
        return inputDevice.getIntNumber();
    }
}
