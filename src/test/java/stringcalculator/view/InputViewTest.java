package stringcalculator.view;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {

    @Test
    void input() {
        //given
        String input = "1 + 2 * 2";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(input.getBytes());

        //when
        InputView inputView = new InputView(byteArrayInputStream);

        //then
        assertThat(inputView.input()).isEqualTo(input);

    }
}