package carracing.presentation.impl;

import carracing.domain.Round;
import carracing.domain.Score;
import carracing.presentation.ResultPresentation;
import carracing.repository.RoundRepository;
import carracing.service.RacingService;
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

public class ResultPresentationV0Test {
    private static final Logger log = Logger.getLogger("ResultViewV0Test");
    private ResultPresentation resultPresentation;
    private OutputStream outputStream;
    private RacingService racingService;

    @BeforeEach
    public void beforeEach() {
        this.outputStream = new ByteArrayOutputStream();
        this.resultPresentation = new ResultPresentationV0(new PrintStream(new PrintStream(outputStream)), new RacingService(new RoundRepository()));
        this.racingService = new RacingService(new RoundRepository());
    }

    @DisplayName("경기결과가 CarIndex 와 함께 출력된다")
    @Test
    public void withCarIndex() {
        //given
        resultPresentation.printResult();

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
        resultPresentation.printResult();

        //then
        assertAll(
            () -> assertEquals(output, outputStream.toString())
            //() -> assertThat(racingService.getAllRounds()).hasSize(inputRoundToScoreListMap.size())
        );
    }
}