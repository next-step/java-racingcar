package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.game.car.CarName;
import step3.game.PositiveNumber;
import step3.view.input.InputView;
import step4.mock.TestInputView;

import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class InputViewTest {

    InputView inputView;

    @Test
    @DisplayName("사용자는 자동차의 개수를 입력할 수 있다.")
    void inputCarNumbers() {
        String input = "3";
        inputView = new TestInputView(input);
        PositiveNumber output = inputView.carCount();
        assertThat(output.number).isEqualTo(Integer.parseInt(input));
    }

    @Test
    @DisplayName("사용자는 시도할 횟수를 입력할 수 있다.")
    void inputTryCount() {
        String input = "3";
        inputView = new TestInputView(input);
        PositiveNumber output = inputView.tryCount();
        assertThat(output.number).isEqualTo(Integer.parseInt(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "name1,name2",
            "carA,carB,carC",
            "one,two,three,four",
    })
    @DisplayName("사용자는 경주할 자동차 이름을 입력할 수 있다.(이름은 쉼표(,)를 기준으로 구분한다.)")
    void inputNames() {
        String input = "name,name2";
        inputView = new TestInputView(input);
        Set<CarName> carNames = inputView.carNames();
        int expectedOutput = input.split(",").length;
        assertThat(carNames.size()).isEqualTo(expectedOutput);
    }
}
