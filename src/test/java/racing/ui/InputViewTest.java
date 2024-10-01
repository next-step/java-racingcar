package racing.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.car.ui.InputView;

import java.util.InputMismatchException;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {

    @Test
    @DisplayName("input 메서드 실행 시, 입력한 숫자를 반환해야한다.")
    void input_메서드_테스트() {
        Scanner scanner = new Scanner("3");
        InputView view = new InputView(scanner);

        int number = view.input();

        assertThat(number).isEqualTo(3);
    }

    @Test
    @DisplayName("input 메서드 실행 후, 문자열 입력시 InputMismatchException 예외 발생")
    void input_메서드_문자_입력_예외_테스트() {
        Scanner scanner = new Scanner("asb");
        InputView view = new InputView(scanner);

        assertThatThrownBy(view::input).isInstanceOf(InputMismatchException.class);
    }
}
