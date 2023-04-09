package carracing.ui;

import carracing.logic.AutomobileFederation;
import carracing.logic.type.Round;
import carracing.logic.type.Score;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class ResultViewV2Test {
    private static final Logger log = Logger.getLogger("ResultViewV2Test");
    private ResultView resultView;
    private OutputStream outputStream;

    @BeforeEach
    public void beforeEach() {
        outputStream = new ByteArrayOutputStream();
        this.resultView = new ResultViewV2(new PrintStream(new PrintStream(outputStream)));
    }

    @Disabled("V2버전은 아직 개발이 완료되지 않았습니다")
    @DisplayName("경기결과가 CarIndex 와 함께 출력된다")
    @Test
    public void withCarIndex() {
        //given
        Map<Round, List<Score>> inputRoundToScoreListMap = Map.of(
                new Round(5), Arrays.asList(new Score(1), new Score(4), new Score(5)),
                new Round(1), Arrays.asList(new Score(7), new Score(3), new Score(9)),
                new Round(2), Arrays.asList(new Score(5), new Score(2), new Score(1)),
                new Round(3), Arrays.asList(new Score(9), new Score(4), new Score(5)),
                new Round(4), Arrays.asList(new Score(8), new Score(8), new Score(8))
        );
        String output = "" +
                "1 : -\n" +
                "2 : \n" +
                "3 : -\n" +
                "\n" +
                "1 : --\n" +
                "2 : \n" +
                "3 : -\n" +
                "\n" +
                "1 : ---\n" +
                "2 : \n" +
                "3 : --\n" +
                "\n" +
                "1 : ----\n" +
                "2 : -\n" +
                "3 : ---\n" +
                "\n" +
                "1 : ----\n" +
                "2 : -\n" +
                "3 : ----\n" +
                "\n";

        //when
        AutomobileFederation automobileFederation = new AutomobileFederation(inputRoundToScoreListMap);
        resultView.printResult(automobileFederation);

        //then
        assertAll(
                () -> assertEquals(outputStream.toString(), output),
                () -> assertThat(automobileFederation.getRounds()).hasSize(inputRoundToScoreListMap.size()),
                () -> log.warning("ResultView 를 테스트해야하는데, AutomobileFederation 가 실패하면 해당 테스도 실패한다"),
                () -> log.warning("UI 컴포넌트인 ResultView 만을 순수하게 테스트할수 있도록 구조를 개선해야한다")
        );
    }
}