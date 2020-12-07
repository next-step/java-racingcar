package racing.view;

import dto.Response;
import racing.domain.CarReport;
import racing.domain.RoundReport;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {

    private static final String RESULT = "실행 결과";
    private static final String CAR_REPORT_FORMAT = "%s : %s";
    private static final String LOCATION_SYMBOL = "-";
    private static final String DELIMITER = "\n";
    private static final String ROUND_DELIMITER = "\n\n";
    private static final String WINNER = "가 최종 우승했습니다.";
    private static final String WINNER_DELIMITER = ",";

    public static void print(final Response response) {
        System.out.println(RESULT);
        printRoundReports(response.getRoundReports());
        printWinners(response.getWinners());
    }

    private static void printWinners(final List<String> winners) {
        System.out.println(String.join(WINNER_DELIMITER, winners) + WINNER);
    }

    private static void printRoundReports(final List<RoundReport> roundReports) {
        System.out.println(roundReports.stream()
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
        return String.format(CAR_REPORT_FORMAT, carReport.getName(), getLocationSymbol(carReport.getLocation()));

    }

    private static String getLocationSymbol(final int location) {
        return IntStream.range(0, location)
                .mapToObj(ignore -> LOCATION_SYMBOL)
                .collect(Collectors.joining());
    }
}
