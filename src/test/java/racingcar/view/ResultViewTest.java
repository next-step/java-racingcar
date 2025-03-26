package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarState;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ResultViewTest {

    @Test
    @DisplayName("자동차 경주의 실행 결과를 출력한다.")
    void printStartResult() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        List<List<CarState>> result = List.of(
                List.of(new CarState("luna", 1), new CarState("star", 0)),
                List.of(new CarState("luna", 1), new CarState("star", 1))
        );

        ResultView resultView = new ResultView();
        resultView.print(result);

        assertThat(out.toString()).containsPattern("실행 결과\\R((-*\\R)*\\R)*");
    }

}