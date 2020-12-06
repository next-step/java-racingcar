package racing.view;

import dto.Response;
import racing.domain.CarReport;
import racing.domain.RoundReport;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {

    private static final String RESULT = "실행 결과";
    private static final String LOCATION_SYMBOL = "-";
    private static final String DELIMITER = "\n";
    private static final String ROUND_DELIMITER = "\n\n";

    public static void print(final Response response) {
        System.out.println(RESULT);
        printRoundReports(response);
    }

    private static void printRoundReports(final Response response) {
        System.out.print(response.getRoundReports()
                .stream()
                .map(ResultView::getRoundReport)
                .collect(Collectors.joining(ROUND_DELIMITER)));
    }

    private static String getRoundReport(final RoundReport roundReport) {
        return roundReport.getCarReports()
                .stream()
                .map(ResultView::getCarReport)
                .collect(Collectors.joining(DELIMITER));
    }

    private static String getCarReport(final CarReport carReport) {
        return IntStream.range(0, carReport.getLocation())
                .mapToObj(ignore -> LOCATION_SYMBOL)
                .collect(Collectors.joining());
    }
}
