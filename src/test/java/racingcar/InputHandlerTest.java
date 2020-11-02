package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.Input;
import racingcar.inputview.ConsoleInputView;
import racingcar.inputview.InputHandler;
import racingcar.mock.MockInputDevice;

import static org.assertj.core.api.Assertions.assertThat;

public class InputHandlerTest {
    private static final String EXPECTED_STRING = "test1" + InputHandler.NAME_DELIMITER + "test2";
    private static final int EXPECTED_NUMBER = 5;
    private InputHandler inputHandler;
    private Input input;

    @BeforeEach
    void init() {
        inputHandler = new InputHandler(new ConsoleInputView(), new MockInputDevice(EXPECTED_STRING, EXPECTED_NUMBER));
        input = inputHandler.getInput();
    }

    @Test
    @DisplayName("Input의 numberOfCountToTry는 입력받은 숫자값과 같다")
    void testInputHandler_getNumberOfCountToTry() {
        assertThat(input.numberOfCountToTry).isEqualTo(EXPECTED_NUMBER);
    }

    @Test
    @DisplayName("Input의 namesOfCars 요소들은 입력받은 문자열값을 InputHandler.NAME_DELIMITER 로 구분하여 분리한것과 같다.")
    void testInputHandler_getNamesOfCars() {
        assertThat(input.namesOfCars).containsExactly("test1", "test2");
    }
}
