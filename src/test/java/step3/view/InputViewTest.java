package step3.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.*;

public class InputViewTest {

    @Test
    @DisplayName("자동차 대수와 라운드 횟수 입력 테스트")
    void setCountTest() {
        // given
        InputView inputView = new InputView();

        // when
        inputView.setCarCount(3);
        inputView.setRoundCount(5);

        // then
        assertThat(inputView.getCarCount()).isEqualTo(3);
        assertThat(inputView.getRoundCount()).isEqualTo(5);
    }

    @Test
    @DisplayName("자동차 대수와 라운드 횟수 입력 실패 테스트")
    void setCountFailTest() {
        InputView inputView = new InputView();

        assertThatIllegalArgumentException()
                .isThrownBy(() -> inputView.setCarCount(0))
                .withMessageMatching("1이상의 숫자를 입력하세요");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> inputView.setRoundCount(-1))
                .withMessageMatching("1이상의 숫자를 입력하세요");
    }

    @Test
    @DisplayName("자동차 이름 입력 테스트")
    void setNamesTest() {
        // given
        InputView inputView = new InputView();

        // when
        inputView.setCarNames("BLACK,WHITE,BLUE");

        // then
        assertThat(inputView.getCarNames().length).isEqualTo(3);
        assertThat(inputView.getCarNames()).containsExactly("BLACK", "WHITE", "BLUE");
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("자동차 이름 입력 실패 테스트")
    void setNamesFailTest(String input) {
        InputView inputView = new InputView();

        assertThatIllegalArgumentException()
                .isThrownBy(() -> inputView.setCarNames(input))
                .withMessageMatching("null 또는 빈값을 입력할 수 없습니다");
    }
}
