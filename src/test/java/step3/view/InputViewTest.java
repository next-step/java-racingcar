package step3.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
