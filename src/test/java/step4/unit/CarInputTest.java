package step4.unit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import step3.view.InputView;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CarInputTest {

    InputView inputView;
    @Mock
    Scanner scanner;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        inputView = new InputView(scanner);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1,0})
    void 이동횟수_입력값이_0이하인경우_예외발생(int input) {
        Mockito.when(scanner.nextInt())
                .thenReturn(input);

        assertThatThrownBy(() -> inputView.inputNumberOfMoves())
                .isInstanceOf(RuntimeException.class)
                .hasMessage("입력값은 1 이상이어야 합니다.");
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 자동차이름_입력값이_비어있을경우_예외발생(String input) {
        Mockito.when(scanner.nextLine())
                .thenReturn(input);

        assertThatThrownBy(() -> inputView.inputCars())
                .isInstanceOf(RuntimeException.class)
                .hasMessage("입력된 자동차 이름이 없습니다.");
    }

    @Test
    void 자동차이름을_입력받을수있다() {
        Mockito.when(scanner.nextLine())
                .thenReturn("benz,bmw,audi");

        assertThatCode(() -> inputView.inputCars())
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2,10})
    void 이동횟수를_입력받을수있다(int input) {
        Mockito.when(scanner.nextInt())
                .thenReturn(input);

        assertThatCode(() -> inputView.inputNumberOfMoves())
                .doesNotThrowAnyException();
    }
}
