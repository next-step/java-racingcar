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
    @DisplayName("inputCar 메서드 5글자미만 입력시 성공")
    void input_Car_메서드_테스트_성공() {
        Scanner scanner = new Scanner("leo,seo");
        InputView view = new InputView(scanner);

        String[] carNames = view.inputCar();

        assertThat(carNames).isEqualTo(new String[]{"leo", "seo"});
    }

    @Test
    @DisplayName("inputCar 메서드 5글자 초과 시 예외 발생")
    void input_Car_메서드_5글자_초과_예외_테스트() {
        Scanner scanner = new Scanner("leo,seoun");
        InputView view = new InputView(scanner);

        assertThatThrownBy(view::inputCar)
                .isInstanceOf(RuntimeException.class)
                .hasMessageMatching("이름은 5글자 미만으로 입력해주세요.");
    }

}
