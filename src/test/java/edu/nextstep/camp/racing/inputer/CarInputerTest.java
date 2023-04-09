package edu.nextstep.camp.racing.inputer;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

public class CarInputerTest {

    private CarInputer carInputer;

    @BeforeEach
    void init() {
        carInputer = new CarInputer();
    }

    @Test
    @DisplayName("자동자 댓수 입력 정상 확인")
    void car_input() {
        systemSetIn("5");

        InputPositiveResult inputResult = carInputer.input();

        Assertions.assertThat(inputResult.result())
                .isEqualTo(5);
    }

    @DisplayName("자동자 댓수 양수외 및 범위 외 값 입력시 재입력 유도 확인")
    @Test
    void car_input_checked_not_integer() {
        systemSetIn("-1\n-2\ndf3\n3ㅇ\n1\n21\n5");
        InputPositiveResult inputResult = carInputer.input();

        Assertions.assertThat(inputResult.result())
                .isEqualTo(5);
    }

    private void systemSetIn(String inputString) {
        ByteArrayInputStream in = new ByteArrayInputStream(inputString.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);
    }
}
