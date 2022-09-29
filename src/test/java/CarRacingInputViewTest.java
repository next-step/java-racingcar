import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;

@DisplayName("자동차 대수 입력 테스트")
public class CarRacingInputViewTest {

    @ParameterizedTest(name = "양의 정수 입력시 올바르게 반환")
    @CsvSource(value = {"1:1", "2:2"}, delimiter = ':')
    void getCarCountInputTest(String input, Integer output) {
        Scanner scanner = _generateInputScanner(input);

        assertThat(CarRacingInputView.getCarCountInput(scanner)).isEqualTo(output);
    }

    @ParameterizedTest(name = "0이나 음의 정수 입력시 에러 발생")
    @ValueSource(strings = {"0", "-1"})
    void getCarCountInputWithNotPositiveIntegerInputExceptionTest(String input) {
        Scanner scanner = _generateInputScanner(input);

        assertThatThrownBy(() -> CarRacingInputView.getCarCountInput(scanner))
                .isInstanceOf(InputMismatchException.class);
    }

    @ParameterizedTest(name = "정수가 아닌 데이터 입력시 에러 발생")
    @ValueSource(strings = {"abc", "1.23"})
    void getCarCountInputWithNonIntegerInputExceptionTest(String input) {
        Scanner scanner = _generateInputScanner(input);

        assertThatThrownBy(() -> CarRacingInputView.getCarCountInput(scanner))
                .isInstanceOf(InputMismatchException.class);
    }

    @ParameterizedTest(name = "공백 입력시 에러 발생")
    @ValueSource(strings = {"", " "})
    void getCarCountInputWithBlankInputExceptionTest(String input) {
        Scanner scanner = _generateInputScanner(input);

        assertThatThrownBy(() -> CarRacingInputView.getCarCountInput(scanner))
                .isInstanceOf(NoSuchElementException.class);
    }

    private Scanner _generateInputScanner(String input) {
        InputStream in = _generateUserInput(input);
        System.setIn(in);
        return new Scanner(System.in);
    }

    private InputStream _generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}
