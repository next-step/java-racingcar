package racingcar.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.ResultView;

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
    @DisplayName("자동차 이름 질문 출력")
    void nameOfCars() {
        String request = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).\n";

        ResultView.printNameOfCars();

        assertThat(out.toString()).isEqualTo(request);
    }

    @Test
    @DisplayName("시도 횟수 질문 출력")
    void numberOfMovement() {
        String request = "시도할 회수는 몇 회 인가요?\n";

        ResultView.printNumberOfMovements();

        assertThat(out.toString()).isEqualTo(request);
    }

    @Test
    @DisplayName("실행 결과 문장 출력")
    void result() {
        String request = "실행 결과\n";

        ResultView.printRacingResult();

        assertThat(out.toString()).isEqualTo(request);
    }

    @Test
    @DisplayName("다수 자동차 이동 현황")
    void statusOfCars() {
        int[] distances = {1, 2, 3};
        String expected = "-\n--\n---\n\n";

        ResultView.printStatusOfCars(distances);

        assertThat(out.toString()).isEqualTo(expected);
    }
}
