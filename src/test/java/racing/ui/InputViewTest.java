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
    @DisplayName("inputTry 메서드 실행 시, 입력한 숫자를 반환해야한다.")
    void input_Try_메서드_테스트() {
        Scanner scanner = new Scanner("3");
        InputView view = new InputView(scanner);

        int number = view.inputTry();

        assertThat(number).isEqualTo(3);
    }

    @Test
    @DisplayName("inputTry 메서드 실행 후, 문자열 입력시 InputMismatchException 예외 발생")
    void input_Try_메서드_문자_입력_예외_테스트() {
        Scanner scanner = new Scanner("asb");
        InputView view = new InputView(scanner);

        assertThatThrownBy(view::inputTry).isInstanceOf(InputMismatchException.class);
    }

    @Test
    @DisplayName("splitTry 메서드 테스트 이름 문자열 쉼표 구분시  String 배열에 저장")
    void splitTry_메서드_테스트() {
        String input = "leo,bara,bake";
        String[] carNames = input.split(",");

        assertThat(carNames).isEqualTo(new String[]{"leo", "bara", "bake"});
    }
}
