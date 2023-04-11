package carrace;

import java.util.List;

public class ResultView {
    private static final String DASH = "-";
    public static void print(CarRace carRace) {
        System.out.println("실행 결과");
        final List<Integer> carsPosition = carRace.getCarsPosition();
        carsPosition.stream()
                .map(ResultView::getDash)
                .forEach(System.out::println);
    }

    private static String getDash(Integer integer) {
        return DASH.repeat(integer);
    }
}
