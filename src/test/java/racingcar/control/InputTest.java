package racingcar.control;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.control.input.CarCountInput;
import racingcar.control.input.StandardInput;
import racingcar.control.input.TrialInput;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.InputMismatchException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("사용자 입력 컨트롤러 테스트")
class InputTest {

    @ParameterizedTest
    @ValueSource(strings = {"\"", ".", "10/2", "a"})
    @DisplayName("자동차 대수로 정수가 아닌 값을 받으면 예외가 나야 한다")
    public void carInput(String value) {
        InputStream in = new ByteArrayInputStream(value.getBytes());
        System.setIn(in);

        StandardInput<Integer> input = new CarCountInput();
        assertThatThrownBy(input::getValue)
                .isInstanceOf(InputMismatchException.class)
                .hasMessage("input must be integer");

        System.setIn(System.in);
    }


    @ParameterizedTest
    @ValueSource(strings = {"\"", ".", "10/2", "a"})
    @DisplayName("실행 횟수로 정수가 아닌 값을 받으면 예외가 나야 한다")
    public void trailsInput(String value) {
        InputStream in = new ByteArrayInputStream(value.getBytes());
        System.setIn(in);

        StandardInput<Integer> input = new TrialInput();
        assertThatThrownBy(input::getValue)
                .isInstanceOf(InputMismatchException.class)
                .hasMessage("input must be integer");

        System.setIn(System.in);
    }
}