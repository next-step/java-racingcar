package carracing.presentation.impl;

import carracing.presentation.ResultPresentation;
import carracing.repository.RoundRepository;
import carracing.service.RacingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.logging.Logger;

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
        racingService.racingStart(3, 4);
        resultPresentation.printResult();

        log.info(outputStream.toString());

    }
}