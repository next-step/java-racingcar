package step3;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {

    @ParameterizedTest
    @ValueSource(strings = {"abc,def,hij"})
    void readCarNames(String input) {

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String s = InputView.readStringInput("");
        assertThat(s).isEqualTo(input);

    }

}