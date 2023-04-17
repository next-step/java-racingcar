package carrace;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {
    private static final String DISTANCE = "-";
    private static final String LINE_BREAK = "\n";
    public static void print(CarRace carRace) {
        prePrint();
        final String result = carRace.getResults()
                .stream()
                .map(ResultView::carsPositionToDistanceWithName)
                .collect(Collectors.joining(LINE_BREAK.repeat(2)));
        System.out.println(result);
        System.out.printf("\n %s가 최종 우승했습니다.", String.join(", ", carRace.getWinners()));
    }

    private static String carsPositionToDistanceWithName(Cars cars) {
        return IntStream.range(0, cars.size())
                .mapToObj(index -> getDistanceWithName(cars.getCarName(index), cars.getPosition(index)))
                .collect(Collectors.joining(LINE_BREAK));
    }

    private static String getDistanceWithName(String name, Integer integer) {
        return name + " : " + DISTANCE.repeat(integer);
    }

    private static void prePrint() {
        System.out.println("\n실행 결과");
    }
}
