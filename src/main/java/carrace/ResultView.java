package carrace;

import java.util.List;

public class ResultView {
    private static final String DASH = "-";
    public static void print(Cars cars) {
        final List<Integer> carsPosition = cars.getPositions();
        carsPosition.stream()
                .map(ResultView::getDash)
                .forEach(System.out::println);
        System.out.println();
    }

    private static String getDash(Integer integer) {
        return DASH.repeat(integer);
    }

    public static void prePrint() {
        System.out.println("\n실행 결과");
    }
}
