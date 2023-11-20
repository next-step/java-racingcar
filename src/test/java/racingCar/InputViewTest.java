package racingCar;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingCar.mock.FakePrinter;
import racingCar.mock.FakeReader;
import racingCar.view.InputView;
import racingCar.view.printer.Printer;
import racingCar.view.reader.Reader;

public class InputViewTest {
    private Printer printer = new FakePrinter();

    @DisplayName("플레이어의 입력 형식은 ,로 구분된 올바른 형식으로 입력되어야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", ",pobi,crong,honux", "pobi,crong,honux,", "pobi,,,crong,honux"})
    void inputPlayer(String input) {
        // given
        Reader reader = new FakeReader(input);
        InputView inputView = InputView.of(reader, printer);

        assertThatIllegalArgumentException().isThrownBy(inputView::inputPlayer)
                .withMessage("플레이어의 이름은 ,로 구분된 형식으로 입력해야합니다. 예) pobi,crong,honux");
    }

    @DisplayName("플레이어의 입력 형식은 ,로 구분된 올바른 형식이면 예외를 던지지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"pobi,crong,honux", "pobi,honux"})
    void inputPlayerValid(String input) {
        // given
        Reader reader = new FakeReader(input);
        InputView inputView = InputView.of(reader, printer);

        assertThatCode(inputView::inputPlayer)
                .doesNotThrowAnyException();
    }
}
