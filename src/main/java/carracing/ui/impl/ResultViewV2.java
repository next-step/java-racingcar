package carracing.ui.impl;

import carracing.logic.AutomobileFederation;
import carracing.ui.ResultView;

import java.io.PrintStream;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.logging.Logger;

public class ResultViewV2 implements ResultView {

    private static final Logger log = Logger.getLogger("ResultViewV1");
    private static final Boolean DISPLAY_CAR_INDEX = Boolean.TRUE;
    private static final Boolean DISPLAY_ROUND_INFORMATION = Boolean.TRUE;

    private final PrintStream printStream;

    public ResultViewV2(PrintStream printStream) {
        log.info("ResultViewV2 에서는 DISPLAY_CAR_INDEX, DISPLAY_ROUND_INFORMATION 두가지에 대한 표시여부를 결정할 수 있습니다");
        this.printStream = printStream;
    }

    /*
    consumer<AutomobileFederation> printer = DISPLAY_CAR_INDEX ?
                    this::printResultWithCarIndex :
                    this::printResultWithoutCarIndex;

            printer.accept(federation);
     */
    @Override
    public void printResult(AutomobileFederation federation) {
        AtomicInteger indexHolder = new AtomicInteger();

        Consumer<String> printer = DISPLAY_CAR_INDEX ?
            s -> printStream.println(indexHolder.getAndIncrement() + 1 + " : " + s) :
            printStream::println;

        federation.getRounds().forEach(round -> {
            federation.lapSituations(round).forEach(printer);
            printStream.println();
        });
    }
}
//        federation.getRounds().forEach(round -> {
//            federation.lapSituations(round).forEach(printStream::println);
//            printStream.println();
//        });
