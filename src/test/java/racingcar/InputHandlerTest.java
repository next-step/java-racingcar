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
    private static final int EXPECTED_NUMBER = 5;
    private InputHandler inputHandler;

    @BeforeEach
    void init() {
        inputHandler = new InputHandler(new ConsoleInputView(), new MockInputDevice(EXPECTED_NUMBER));
    }

    @Test
    @DisplayName("Input의 필드값들은 InputDevice에서 입력받은 값과 같다")
    void testInputHandler_getIntNumber() {
        Input input = inputHandler.getInput();

        assertThat(input.numberOfCar).isEqualTo(EXPECTED_NUMBER);
        assertThat(input.numberOfCountToTry).isEqualTo(EXPECTED_NUMBER);
    }
}
