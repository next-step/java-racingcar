package racingcar.io;

import java.util.Scanner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.exception.InvalidInputException;
import racingcar.io.InputView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {

    @Test
    @DisplayName("자동차 대수 입력 테스트")
    void inputCarTest() throws InvalidInputException {
        Scanner scanner = new Scanner("5");
        InputView inputView = new InputView(scanner);

        int carCount = inputView.getCarCount();
        assertThat(carCount).isEqualTo(5);
    }

    @Test
    @DisplayName("시도 횟수 입력 테스트")
    void inputMovementTest() throws InvalidInputException {
        Scanner scanner = new Scanner("3");
        InputView inputView = new InputView(scanner);

        int movementCount = inputView.getMovementCount();
        assertThat(movementCount).isEqualTo(3);
    }

    @Test
    @DisplayName("자동차 대수에 0을 입력하면 예외 발생")
    void inputCarTestException() {
        Scanner scanner = new Scanner("0");
        InputView inputView = new InputView(scanner);

        assertThatThrownBy(inputView::getCarCount)
            .isInstanceOf(InvalidInputException.class);
    }

    @Test
    @DisplayName("시도 횟수에 문자를 입력하면 예외 발생")
    void inputMovementTestException() {
        Scanner scanner = new Scanner("sss");
        InputView inputView = new InputView(scanner);

        assertThatThrownBy(inputView::getMovementCount)
            .isInstanceOf(InvalidInputException.class);
    }
}
