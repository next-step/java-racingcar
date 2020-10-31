package racingcar;

public class InputHandler {
    private final InputView inputView;
    private final InputDevice inputDevice;

    public InputHandler(InputView inputView, InputDevice inputDevice) {
        this.inputView = inputView;
        this.inputDevice = inputDevice;
    }

    public Input getInput() {
        inputView.print("자동차 대수는 몇 대 인가요?");
        int numberOfCar = inputDevice.getIntNumber();

        inputView.print("시도할 회수는 몇 회 인가요?");
        int numberOfCountOfTry = inputDevice.getIntNumber();

        return Input.builder()
                .numberOfCar(numberOfCar)
                .numberOfCountToTry(numberOfCountOfTry)
                .build();
    }
}
