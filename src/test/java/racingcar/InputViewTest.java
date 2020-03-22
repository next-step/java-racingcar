package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.view.InputView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class InputViewTest {
    @DisplayName("null 또는 공백문자열이 입력되면 예외가 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void validInputTest(String input) {
        //when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new InputView(input, input));
    }

    @DisplayName("숫자가 아닌 문자열이 입력되면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"@", "*", "A", "!", "J"})
    void validNumberTest(String input) {
        //when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new InputView(input, input));
    }

    @DisplayName("tryCount에 1보다 작은 수를 입력하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"-10", "0", "-1", "-100"})
    void validateNegativeTest(String tryCount ) {
        //when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new InputView("carNames", tryCount));
    }

    @DisplayName("자동차 이름을 문자열로 입력하면 자동차 객체의 대수를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"pobi,crong,honux:3", "1,2,3,4,5:5", "Mark,Jaehyun,Johnny:3"}, delimiter = ':')
    void insertCarNamesTest(String carNames, int expectedCarCount) {
        //give
        InputView inputView = new InputView(carNames, "3");

        //then
        assertThat(inputView.getCarCount()).isEqualTo(expectedCarCount);
    }
}