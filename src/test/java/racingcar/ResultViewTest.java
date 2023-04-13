package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultViewTest {

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

        ResultView.registerNumberOfCars();

        assertThat(out.toString()).isEqualTo(request);
    }

    @Test
    @DisplayName("시도 횟수 질문 출력")
    void numberOfMovement() {
        String request = "시도할 회수는 몇 회 인가요?\n";

        ResultView.registerNumberOfMovements();

        assertThat(out.toString()).isEqualTo(request);
    }

    @Test
    @DisplayName("실행 결과 문장 출력")
    void result() {
        String request = "실행 결과\n";

        ResultView.getRacingResult();

        assertThat(out.toString()).isEqualTo(request);
    }

    @Test
    @DisplayName("다수 자동차 이동 현황")
    void statusOfCars() {
        int[] distances = {1, 2, 3};
        String expected = "-\n--\n---\n";

        ResultView.getStatusOfCars(distances);

        assertThat(out.toString()).isEqualTo(expected);
    }
}
