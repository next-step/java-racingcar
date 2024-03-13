package racing.view;

import racing.domain.RoundRecord;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private static final String GAME_RESULT = "실행 결과";
    private static final String NEW_LINE = System.lineSeparator();
    private static final String POSITION_MARK = "_";
    private static final String PRINT_FORMAT = "{0} : {1}";

    public static void showResult(List<RoundRecord> records) {
        StringBuilder printResult = new StringBuilder();
        printResult.append(GAME_RESULT);
        printResult.append(NEW_LINE);
        for (RoundRecord roundRecord : records) {
            printResult.append(print(roundRecord));
            printResult.append(NEW_LINE);
            printResult.append(NEW_LINE);
        }
        System.out.println(printResult.toString());
    }

    private static String print(RoundRecord roundRecord) {
//        StringBuilder result = new StringBuilder();
//        roundRecord.getPositions().forEach((name, position) -> {
//            result.append(name + " : " + POSITION_MARK.repeat(Math.max(0, position)));
//            result.append(NEW_LINE);
//        });
//      return result.toString();
//  }
        return roundRecord.getPositions().entrySet()
                .stream()
                //.map(i -> i.getKey() + " : " + POSITION_MARK.repeat(Math.max(0, i.getValue())))
                .map(i -> MessageFormat.format(PRINT_FORMAT, i.getKey(), POSITION_MARK.repeat(Math.max(0, i.getValue()))))
                //.map(i -> String.format("%s : %s", i.getKey(), POSITION_MARK.repeat(Math.max(0, i.getValue()))))
                .collect(Collectors.joining(NEW_LINE));
    }
}
