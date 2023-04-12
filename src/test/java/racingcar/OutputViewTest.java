package racingcar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputViewTest {

    private OutputStream out;

    @BeforeEach
    void before() {
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @Test
    @DisplayName("자동차 대수 질문 출력")
    void numberOfCars() {
        String request = "자동차 대수는 몇 대 인가요?\n";

        OutputView.registerNumberOfCars();

        assertThat(out.toString()).isEqualTo(request);
    }

    @Test
    @DisplayName("시도 횟수 질문 출력")
    void numberOfMovement() {
        String request = "시도할 회수는 몇 회 인가요?\n";

        OutputView.registerNumberOfMovements();

        assertThat(out.toString()).isEqualTo(request);
    }
}
