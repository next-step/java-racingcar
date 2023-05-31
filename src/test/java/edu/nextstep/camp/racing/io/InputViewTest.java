package edu.nextstep.camp.racing.io;

import org.junit.jupiter.api.Test;

import static edu.nextstep.camp.testUtils.TestUtils.systemSetIn;
import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {

    @Test
    void scanner_input_test(){
        systemSetIn("test");

        assertThat(InputView.input())
                .isEqualTo("test");
    }
}
