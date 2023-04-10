package carracing.ui.impl;

import carracing.logic.RacingService;
import carracing.logic.type.Round;
import carracing.logic.type.Score;
import org.junit.jupiter.api.BeforeEach;
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
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResultViewV1Test {
    private static final Logger log = Logger.getLogger("ResultViewV1Test");
    private ResultViewV1 resultViewV1;
    private OutputStream outputStream;

    @BeforeEach
    public void beforeEach() {
        outputStream = new ByteArrayOutputStream();
        this.resultViewV1 = new ResultViewV1(new PrintStream(new PrintStream(outputStream)));
    }

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
                "2 : -\n" +
                "3 : --\n" +
                "\n" +
                "1 : ----\n" +
                "2 : --\n" +
                "3 : ---\n" +
                "\n" +
                "1 : ----\n" +
                "2 : ---\n" +
                "3 : ----\n" +
                "\n";

        //when
        RacingService racingService = new RacingService(inputRoundToScoreListMap);
        resultViewV1.printResultWithCarIndex(racingService);

        //then
        assertAll(
                () -> assertEquals(output, outputStream.toString()),
                () -> assertThat(racingService.getRounds()).hasSize(inputRoundToScoreListMap.size()),
                () -> log.warning("ResultView 를 테스트해야하는데, AutomobileFederation 가 실패하면 해당 테스도 실패한다"),
                () -> log.warning("UI 컴포넌트인 ResultView 만을 순수하게 테스트할수 있도록 구조를 개선해야한다")
        );
    }

    @DisplayName("경기결과가 출력된다")
    @Test
    public void iteration2() {
        //given
        Map<Round, List<Score>> inputRoundToScoreListMap = Map.of(
                new Round(5), Arrays.asList(new Score(1), new Score(4), new Score(5)),
                new Round(1), Arrays.asList(new Score(7), new Score(3), new Score(9)),
                new Round(2), Arrays.asList(new Score(5), new Score(2), new Score(1)),
                new Round(3), Arrays.asList(new Score(9), new Score(4), new Score(5)),
                new Round(4), Arrays.asList(new Score(8), new Score(8), new Score(8))

        );
        String output = "" +
                "-\n" +
                "\n" +
                "-\n" +
                "\n" +
                "--\n" +
                "\n" +
                "-\n" +
                "\n" +
                "---\n" +
                "-\n" +
                "--\n" +
                "\n" +
                "----\n" +
                "--\n" +
                "---\n" +
                "\n" +
                "----\n" +
                "---\n" +
                "----\n" +
                "\n";

        //when
        RacingService racingService = new RacingService(inputRoundToScoreListMap);
        resultViewV1.printResultWithoutCarIndex(racingService);

        //then
        assertAll(
                () -> assertEquals(output, outputStream.toString()),
                () -> assertThat(racingService.getRounds()).hasSize(inputRoundToScoreListMap.size())
        );
    }
}