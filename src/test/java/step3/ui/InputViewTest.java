package step3.ui;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputViewTest {
    @ParameterizedTest
    @ValueSource(strings = {"a\n", "\n"})
    void Given_Not_Integer_When_InputNumber_Then_ThrowError(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);

        InputView inputView = new InputView(scanner);

        assertThatThrownBy(() -> inputView.inputInt()).hasMessage(InputView.INPUT_ERROR_MSG);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1\n", "-1\n", "0\n"})
    void Given_Integer_When_InputNumber_Then_Success(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);

        InputView inputView = new InputView(scanner);

        assertThatNoException().isThrownBy(() -> inputView.inputInt());
    }
}
