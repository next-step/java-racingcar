package carracing.ui.impl;

import carracing.logic.repository.RoundRepository;
import carracing.logic.service.RacingService;
import carracing.logic.domain.Round;
import carracing.logic.domain.Score;
import carracing.ui.ResultView;
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

public class ResultViewV0Test {
    private static final Logger log = Logger.getLogger("ResultViewV0Test");
    private ResultView resultView;
    private OutputStream outputStream;
    private RacingService racingService;

    @BeforeEach
    public void beforeEach() {
        this.outputStream = new ByteArrayOutputStream();
        this.resultView = new ResultViewV0(new PrintStream(new PrintStream(outputStream)));
        this.racingService = new RacingService(new RoundRepository());
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
        //RacingService racingService = new RacingService(inputRoundToScoreListMap);
        resultView.printResult(racingService.getData());

        //then
        assertAll(
                () -> assertEquals(output, outputStream.toString()),
                () -> assertThat(racingService.getRounds()).hasSize(inputRoundToScoreListMap.size())
        );
    }
}