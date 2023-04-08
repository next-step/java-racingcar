package racingcar.control.input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.InputMismatchException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("사용자 입력 컨트롤러 테스트")
class InputControlTest {

    @ParameterizedTest
    @ValueSource(strings = {"\"", ".", "10/2", "a"})
    @DisplayName("자동차 대수로 정수가 아닌 값을 받으면 예외가 나야 한다")
    public void carInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        InputControl inputControl = new CarInputControl();
        assertThatThrownBy(inputControl::receiveInt)
                .isInstanceOf(InputMismatchException.class)
                .hasMessage("input must be integer");

        System.setIn(System.in);
    }


    @ParameterizedTest
    @ValueSource(strings = {"\"", ".", "10/2", "a"})
    @DisplayName("실행 횟수로 정수가 아닌 값을 받으면 예외가 나야 한다")
    public void trailsInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        InputControl inputControl = new TrialInputControl();
        assertThatThrownBy(inputControl::receiveInt)
                .isInstanceOf(InputMismatchException.class)
                .hasMessage("input must be integer");

        System.setIn(System.in);
    }
}