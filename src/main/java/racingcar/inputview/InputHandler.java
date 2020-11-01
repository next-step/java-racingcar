package racingcar.inputview;

import racingcar.dto.Input;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputHandler {
    private static final String NAMES_OF_CARS_QUERYING_MSG = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
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

    private List<String> getNumberOfCar() {
        inputView.print(NAMES_OF_CARS_QUERYING_MSG);
        String namesOfCars = inputDevice.getString();
        String[] names = namesOfCars.split(",");
        return Arrays.stream(names)
                .collect(Collectors.toList());
    }

    private int getNumberOfCountOfTry() {
        inputView.print(NUMBER_OF_COUNT_TO_TRY_QUERYING_MSG);
        return inputDevice.getIntNumber();
    }
}
