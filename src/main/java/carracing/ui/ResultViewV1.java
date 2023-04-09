package carracing.ui;

import carracing.logic.AutomobileFederation;

import java.io.PrintStream;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.logging.Logger;

public class ResultViewV1 implements ResultView {
    private static final Logger log = Logger.getLogger("ResultViewV1");
    private static final Boolean DISPLAY_CAR_INDEX = Boolean.TRUE;
    private static final Boolean DISPLAY_ROUND_INFORMATION = Boolean.TRUE;

    private final PrintStream printStream;

    public ResultViewV1(PrintStream printStream) {
        log.info("ResultViewV1 에서는 DISPLAY_CAR_INDEX 만 표시여부를 결정할 수 있습니다");
        this.printStream = printStream;
    }

    public static boolean isForward(int recode) {
        return recode >= 4;
    }

    @Override
    public void printResult(AutomobileFederation federation) {
        Consumer<AutomobileFederation> printer = DISPLAY_CAR_INDEX ?
                this::printResultWithCarIndex :
                this::printResultWithoutCarIndex;

        printer.accept(federation);
    }

    public void printResultWithoutCarIndex(AutomobileFederation federation) {
        federation.getRounds().forEach(round -> {
            federation.lapSituations(round).forEach(printStream::println);
            printStream.println();
        });
    }

    public void printResultWithCarIndex(AutomobileFederation federation) {
        federation.getRounds().forEach(round -> {
            AtomicInteger indexHolder = new AtomicInteger();
            federation.lapSituations(round).forEach(s -> {
                printStream.print(indexHolder.getAndIncrement() + 1);
                printStream.print(" : ");
                printStream.println(s);
            });
            printStream.println();
        });
    }
}
