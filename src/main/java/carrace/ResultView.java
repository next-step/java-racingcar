package carrace;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String DISTANCE = "-";
    private static final String LINE_BREAK = "\n";
    public static void print(CarRace carRace) {
        prePrint();
        final String result = carRace.getResults()
                .stream()
                .map(ResultView::carsPositionToDistance)
                .collect(Collectors.joining(LINE_BREAK.repeat(2)));
        System.out.println(result);
    }

    private static String carsPositionToDistance(List<Integer> carsPosition) {
        return carsPosition.stream()
                .map(ResultView::getDistance)
                .collect(Collectors.joining(LINE_BREAK));
    }

    private static String getDistance(Integer integer) {
        return DISTANCE.repeat(integer);
    }

    private static void prePrint() {
        System.out.println("\n실행 결과");
    }
}
