package racingcar;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    public InputView inputView = new InputView();

    @Test
    void 문자_입력_받기() {
        // Given
        String testInput = "pobi,crong,honux\n5\n";
        ByteArrayInputStream in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        // When
        inputView.init();

        // Then
        assertThat(inputView.getCarNames()).isEqualTo("pobi,crong,honux");
        assertThat(inputView.getTrialCount()).isEqualTo(5);
    }
}