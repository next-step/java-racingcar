package step3.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("게임 결과 출력 테스트")
public class ResultViewTest {

    @DisplayName("여러 스텝의 자동차 상태 출력")
    @Test
    public void getSimulationStepSnapshot() {
        List<List<Integer>> results = Arrays.asList(
                Arrays.asList(1, 1, 1),
                Arrays.asList(2, 1, 2),
                Arrays.asList(3, 2, 3),
                Arrays.asList(4, 3, 4),
                Arrays.asList(4, 4, 5)
        );

        StringWriter output = new StringWriter();
        ResultView resultView = new ResultView(new PrintWriter(output));
        resultView.show(results);

        assertThat(output.toString()).isEqualTo("실행 결과\n" +
                "-\n" +
                "-\n" +
                "-\n" +
                "\n" +
                "--\n" +
                "-\n" +
                "--\n" +
                "\n" +
                "---\n" +
                "--\n" +
                "---\n" +
                "\n" +
                "----\n" +
                "---\n" +
                "----\n" +
                "\n" +
                "----\n" +
                "----\n" +
                "-----\n\n");
    }
}