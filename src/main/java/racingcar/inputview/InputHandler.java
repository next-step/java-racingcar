package racingcar.inputview;

import racingcar.dto.Input;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class InputHandler {
    public static final String NAME_DELIMITER = ",";
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
                .namesOfCars(getNamesOfCars())
                .numberOfCountToTry(getNumberOfCountOfTry())
                .build();
    }

    private List<String> getNamesOfCars() {
        inputView.print(NAMES_OF_CARS_QUERYING_MSG);

        String namesOfCars = inputDevice.getString();
        return Arrays.stream(namesOfCars.split(NAME_DELIMITER))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    private int getNumberOfCountOfTry() {
        inputView.print(NUMBER_OF_COUNT_TO_TRY_QUERYING_MSG);
        return inputDevice.getIntNumber();
    }
}
