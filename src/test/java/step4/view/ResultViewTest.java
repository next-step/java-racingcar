package step4.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.RecordDto;

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
        List<List<RecordDto>> results = Arrays.asList(
                Arrays.asList(new RecordDto("pobi", 1), new RecordDto("crong", 1), new RecordDto("honux", 1)),
                Arrays.asList(new RecordDto("pobi", 2), new RecordDto("crong", 1), new RecordDto("honux", 2)),
                Arrays.asList(new RecordDto("pobi", 3), new RecordDto("crong", 2), new RecordDto("honux", 3)),
                Arrays.asList(new RecordDto("pobi", 4), new RecordDto("crong", 3), new RecordDto("honux", 4)),
                Arrays.asList(new RecordDto("pobi", 5), new RecordDto("crong", 4), new RecordDto("honux", 5))
        );

        StringWriter output = new StringWriter();
        ResultView resultView = new ResultView(new PrintWriter(output));
        resultView.show(results);

        assertThat(output.toString()).isEqualTo("실행 결과\n" +
                "pobi : -\n" +
                "crong : -\n" +
                "honux : -\n" +
                "\n" +
                "pobi : --\n" +
                "crong : -\n" +
                "honux : --\n" +
                "\n" +
                "pobi : ---\n" +
                "crong : --\n" +
                "honux : ---\n" +
                "\n" +
                "pobi : ----\n" +
                "crong : ---\n" +
                "honux : ----\n" +
                "\n" +
                "pobi : -----\n" +
                "crong : ----\n" +
                "honux : -----\n" +
                "\n");
    }

    @DisplayName("우승자 출력")
    @Test
    public void getWinner() {
        List<RecordDto> winnerRecords = Arrays.asList(new RecordDto("pobi", 5),
                new RecordDto("honux", 5));

        StringWriter output = new StringWriter();
        ResultView resultView = new ResultView(new PrintWriter(output));
        resultView.showWinner(winnerRecords);

        assertThat(output.toString()).isEqualTo("pobi, honux가 최종 우승했습니다.");
    }
}