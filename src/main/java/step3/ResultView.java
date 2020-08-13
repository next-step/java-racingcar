package step3;

import java.util.stream.Stream;

public class ResultView {

    public static final String TRACK = "-";
    public static final String DELIMITER = " : ";

    private ResultView(){}

    public static void printStatus(Stream<Car> cars) {
        cars.map(ResultView::addNamePrefix)
            .forEach(System.out::println);
    }

    private static String addNamePrefix(Car car) {
        return new StringBuilder()
            .append(car.getName())
            .append(DELIMITER)
            .append(convertToTrack(car.getMiles()))
            .toString();
    }

    private static String convertToTrack(int miles) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < miles; i++) {
            sb.append(TRACK);
        }
        return sb.toString();
    }

}
