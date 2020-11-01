package racingcar;

public class InputHandler {
    private static final String NUMBER_OF_CAR_QUERYING_MSG = "자동차 대수는 몇 대 인가요?";
    private static final String NUMBER_OF_COUNT_TO_TRY_QUERYING_MSG = "자동차 대수는 몇 대 인가요?";

    private final InputView inputView;
    private final InputDevice inputDevice;

    public InputHandler(InputView inputView, InputDevice inputDevice) {
        this.inputView = inputView;
        this.inputDevice = inputDevice;
    }

    public Input getInput() {
        inputView.print(NUMBER_OF_CAR_QUERYING_MSG);
        int numberOfCar = inputDevice.getIntNumber();

        inputView.print(NUMBER_OF_COUNT_TO_TRY_QUERYING_MSG);
        int numberOfCountOfTry = inputDevice.getIntNumber();

        return Input.builder()
                .numberOfCar(numberOfCar)
                .numberOfCountToTry(numberOfCountOfTry)
                .build();
    }
}
