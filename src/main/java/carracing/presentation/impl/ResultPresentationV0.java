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

//    @Override
//    public void printResult(List<String> resultList) {
//        resultList.forEach(round -> {
//            federation.lapSituations(round).forEach(printStream::println);
//            printStream.println();
//        });
//    }

    @Override
    public void printResult() {
        printStream.print("hello");
        racingService.getAllRounds().forEach(round -> {
            racingService.lapSituations(round).forEach(printStream::println);
        });
    }
}
