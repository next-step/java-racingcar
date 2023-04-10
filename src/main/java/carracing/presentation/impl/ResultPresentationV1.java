package carracing.presentation.impl;

import carracing.service.RacingService;
import carracing.presentation.ResultPresentation;

import java.io.PrintStream;
import java.util.List;
import java.util.logging.Logger;

public class ResultPresentationV1 implements ResultPresentation {
    private static final Logger log = Logger.getLogger("ResultViewV1");
    private static final Boolean DISPLAY_CAR_INDEX = Boolean.TRUE;
    private static final Boolean DISPLAY_ROUND_INFORMATION = Boolean.TRUE;

    private final PrintStream printStream;

    public ResultPresentationV1(PrintStream printStream) {
        log.info("ResultViewV1 에서는 DISPLAY_CAR_INDEX 만 표시여부를 결정할 수 있습니다");
        this.printStream = printStream;
    }

    public static boolean isForward(int recode) {
        return recode >= 4;
    }

    @Override
    public void printResult() {
        throw new RuntimeException();
    }


    //    @Override
//    public void printResult(RacingService federation) {
//        Consumer<RacingService> printer = DISPLAY_CAR_INDEX ?
//            this::printResultWithCarIndex :
//            this::printResultWithoutCarIndex;
//
//        printer.accept(federation);
//    }

    public void printResultWithoutCarIndex(RacingService federation) {
        federation.getRounds().forEach(round -> {
            federation.lapSituations(round).forEach(printStream::println);
            printStream.println();
        });
    }

    public void printResultWithCarIndex(List<String> resultList) {
//        federation.getRounds().forEach(round -> {
//            AtomicInteger indexHolder = new AtomicInteger();
//            federation.lapSituations(round).forEach(s -> {
//                printStream.print(indexHolder.getAndIncrement() + 1);
//                printStream.print(" : ");
//                printStream.println(s);
//            });
//            printStream.println();
//        });
    }
}
