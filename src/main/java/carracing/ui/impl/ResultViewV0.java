package carracing.ui.impl;

import carracing.ui.ResultView;

import java.io.PrintStream;
import java.util.List;
import java.util.logging.Logger;

public class ResultViewV0 implements ResultView {

    private static final Logger log = Logger.getLogger("ResultViewV0");

    private final PrintStream printStream;

    public ResultViewV0(PrintStream printStream) {
        //log.info("ResultViewV0 에서는 기본 출력만을 제공한다");
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
    public void printResult(List<String> resultList) {

    }
}
