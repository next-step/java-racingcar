package racingcar;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {

    public InputView inputView;

    @Test
    void 문자_입력_받기() {
        // Given
        String testInput = "pobi,crong,honux\n5\n";
        ByteArrayInputStream in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        // When
        inputView = new InputView();

        // Then
        assertThat(inputView.getCarNames()).isEqualTo("pobi,crong,honux");
        assertThat(inputView.getTrialCount()).isEqualTo(5);
    }
}