package carracing.ui;

import carracing.logic.AutomobileFederation;
import carracing.logic.type.Round;

import java.io.PrintStream;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public class ResultView {
    private static final Boolean DISPLAY_CAR_INDEX = Boolean.TRUE;
    private static final Boolean DISPLAY_ROUND_INFORMATION = Boolean.TRUE;

    private final PrintStream printStream;

    public ResultView(PrintStream printStream) {
        this.printStream = printStream;
    }

    public static boolean isForward(int recode) {
        return recode >= 4;
    }

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
