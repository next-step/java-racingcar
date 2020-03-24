package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {
    private final String CAR_NAMES = "pobi,crong,honux";
    private final String TIME = "5";
    private InputView inputView;
    private ByteArrayInputStream byteArrayInputStream;


    @DisplayName("자동차 경주 게임에 필요한 입력값을 성공적으로 받는다.")
    @Test
    void validInput() {
        inputView = new InputView(initInputStream(CAR_NAMES));
        assertThat(inputView.inputCarNames()).isEqualTo(CAR_NAMES);

        inputView = new InputView(initInputStream(TIME));
        assertThat(inputView.inputCarCount()).isEqualTo(5);
    }

    private ByteArrayInputStream initInputStream(String input) {
        byteArrayInputStream = new ByteArrayInputStream(input.getBytes());
        return byteArrayInputStream;
    }
}