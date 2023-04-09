package edu.nextstep.camp.racing.inputer;

import edu.nextstep.camp.racing.io.InputView;
import edu.nextstep.camp.testUtils.TestUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import static edu.nextstep.camp.testUtils.TestUtils.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MovingInputerTest {
    private MovingInputer movingInputer;

    @BeforeEach
    void init() {
        movingInputer = new MovingInputer();
    }

    @Test
    @DisplayName("무빙 횟수 입력 정상 확인")
    void car_input() {
        systemSetIn("10");

        InputPositiveResult inputResult = movingInputer.input();

        assertThat(inputResult.result())
                .isEqualTo(10);
    }

    @DisplayName("무빙 횟수 양수외 및 범위 외 값 입력시 재입력 유도 확인")
    @Test
    void car_input_checked_not_integer() {
        systemSetIn("-1\n-2\ndf3\n3ㅇ\n9\n201\n10");

        InputPositiveResult inputResult = movingInputer.input();

        assertThat(inputResult.result())
                .isEqualTo(10);
    }

}