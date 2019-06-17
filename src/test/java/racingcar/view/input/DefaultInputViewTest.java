package racingcar.view.input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class DefaultInputViewTest {

    @Test
    @DisplayName("입력한 자동차수를 정상적으로 가져오는지 확인한다")
    void checkNumberOfCars() {
        // given
        InputView inputView = new DefaultInputView(new MockNumberInputReader(3));
        // when
        Integer result = inputView.getNumberOfCars();
        // then
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("입력한 시도수를 정상적으로 가져오는지 확인한다")
    void checkNumberOfTimes() {
        // given
        InputView inputView = new DefaultInputView(new MockNumberInputReader(5));
        // when
        Integer result = inputView.getNumberOfTimes();
        // then
        assertThat(result).isEqualTo(5);
    }

    @Test
    @DisplayName("음수를 입력한 경우 예외처리를 확인한다")
    void checkNegativeNumber() {
        // given
        InputView inputView = new DefaultInputView(new MockNumberInputReader(-1));

        assertThatExceptionOfType(IllegalArgumentException.class)
                // when
                .isThrownBy(() -> {
                    Integer numberOfTimes =  inputView.getNumberOfTimes();
                // then
                }).withMessageMatching("Invalid input");

    }

    @Test
    @DisplayName("최대값 이상을 입력한 경우 예외처리를 확인한다")
    void checkMaxNumber() {
        // given
        InputView inputView = new DefaultInputView(new MockNumberInputReader(101));

        assertThatExceptionOfType(IllegalArgumentException.class)
                // when
                .isThrownBy(() -> {
                    Integer numberOfTimes = inputView.getNumberOfTimes();
                    // then
                }).withMessageMatching("Invalid input");

    }
}
