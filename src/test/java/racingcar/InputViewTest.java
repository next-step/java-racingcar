package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.dto.InputView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class InputViewTest {
    @DisplayName("null 또는 공백문자열이 입력되면 예외가 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void validInputTest(String input) {
        //when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new InputView().insertTryCount(input));
    }

    @DisplayName("숫자가 아닌 문자열이 입력되면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"@", "*", "A", "!", "J"})
    void validNumberTest(String input) {
        //when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new InputView().insertTryCount(input));
    }

    @DisplayName("음수가 입력되면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"-20", "-1", "-77"})
    void validateNegativeTest(String input) {
        //when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new InputView().insertTryCount(input));
    }

    @DisplayName("입력값의 InputType에 따라 다른 InputView 필드에 저장된다.")
    @ParameterizedTest
    @CsvSource(value = {"5:5", "7:7"}, delimiter = ':')
    void insertValueToFieldTest(String input, int expected) {
        //when
        InputView inputView = new InputView();
        inputView.insertTryCount(input);

        //then
        assertThat(inputView.getTryCount()).isEqualTo(expected);
    }


    @DisplayName("자동차 대수를 문자열로 입력하면 자동차 객체의 대수를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"pobi,crong,honux:3", "1,2,3,4,5:5", "Mark,Jaehyun,Johnny:3"}, delimiter = ':')
    void insertCarNamesTest(String carNames, int expectedCarCount) {
        //give
        InputView inputView = new InputView();

        //when
        int carCount = inputView.insertCarNames(carNames);

        //then

        assertThat(carCount).isEqualTo(expectedCarCount);
    }
}