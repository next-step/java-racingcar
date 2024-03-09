package view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class InputViewTest {

    @DisplayName("사용자로부터 프롬프트를 통해 몇 대의 자동차로 게임할지 입력받는다.")
    @Test
    void test01() {
        // given
        int carCount = 3;
        System.setIn(new ByteArrayInputStream(String.valueOf(carCount).getBytes()));

        // when
        int result = InputView.promptForCarCount();

        // then
        assertThat(result).isEqualTo(carCount);
    }

    @DisplayName("사용자로부터 프롬프트를 통해 몇 대의 자동차로 게임할지를 입력받을 때, 1 이상의 양수가 아닌 경우 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "0:1 이상의 양수만 입력할 수 있습니다.",
            "-1:1 이상의 양수만 입력할 수 있습니다.",
            "a:잘못된 입력 값입니다."
    }, delimiter = ':')
    void test02(String input, String errorMessage) {
        // given
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when / then
        assertThatIllegalArgumentException()
                .isThrownBy(InputView::promptForCarCount)
                .withMessage(errorMessage);
    }

    @DisplayName("사용자로부터 프롬프트를 통해 몇 번의 이동을 시도할지 입력받는다.")
    @Test
    void test03() {
        // given
        int carCount = 3;
        System.setIn(new ByteArrayInputStream(String.valueOf(carCount).getBytes()));

        // when
        int result = InputView.promptForMoveCount();

        // then
        assertThat(result).isEqualTo(carCount);
    }

    @DisplayName("사용자로부터 프롬프트를 통해 몇 번의 이동을 시도할지 입력받을 때, 1 이상의 양수가 아닌 경우 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "0:1 이상의 양수만 입력할 수 있습니다.",
            "-1:1 이상의 양수만 입력할 수 있습니다.",
            "a:잘못된 입력 값입니다."
    }, delimiter = ':')
    void test04(String input, String errorMessage) {
        // given
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when / then
        assertThatIllegalArgumentException()
                .isThrownBy(InputView::promptForMoveCount)
                .withMessage(errorMessage);
    }
}
