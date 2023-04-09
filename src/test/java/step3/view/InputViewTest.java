package step3.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class InputViewTest {

    private final static String ZERO_LESS_THAN_INPUT_USER_GUIDE = "0보다 큰수를 입력해주세요 :(";
    private final static int ZERO = 0;

    @Test
    @DisplayName("1보다 작은수를 입력하면 예외를 던진다")
    public void 입력테스트() {
        InputView inputView = InputView.getInstance();

        assertThatIllegalArgumentException()
                .isThrownBy(() -> inputView.validateLessThanOne(ZERO))
                .withMessageStartingWith(ZERO_LESS_THAN_INPUT_USER_GUIDE);

    }
}