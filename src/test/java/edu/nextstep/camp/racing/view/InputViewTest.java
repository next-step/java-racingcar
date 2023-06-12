package edu.nextstep.camp.racing.view;

import edu.nextstep.camp.testUtils.TestUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class InputViewTest {
    @Test
    void 입력_테스트(){
        String testString = "입력 테스트";
        TestUtils.systemSetIn(testString);

        String result = InputView.input();

        Assertions.assertThat(result).isEqualTo(testString);
    }

    @AfterEach
    void close(){
        InputView.close();
    }
}
