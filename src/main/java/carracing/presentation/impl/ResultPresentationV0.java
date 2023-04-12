package carracing.presentation.impl;

import carracing.presentation.ResultPresentation;
import carracing.service.RacingService;

import java.io.PrintStream;
import java.util.logging.Logger;

public class ResultPresentationV0 implements ResultPresentation {
    private static final Logger log = Logger.getLogger("ResultViewV0");

    private final PrintStream printStream;
    private final RacingService racingService;

    public ResultPresentationV0(PrintStream printStream, RacingService racingService) {
        this.racingService = racingService;
        this.printStream = printStream;

    }

    @Override
    public void printResult() {
        printStream.print("\n실행 결과\n");
        racingService.racingResults().forEach(round -> {
            round.getRecords().forEach(record -> {
                printStream.println(record.getRecord());
            });
            printStream.print("\n\n");
        });
    }
}
