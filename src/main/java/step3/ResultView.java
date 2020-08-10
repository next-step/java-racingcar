package step3;

import java.util.stream.Stream;

public class ResultView {

    public static final String TRACK = "-";

    public static void printStatus(Stream<Car> cars) {
        cars.map((c) -> convertToTrack(c.getMiles()))
            .forEach(System.out::println);
    }

    private static String convertToTrack(int miles) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < miles; i++) {
            sb.append(TRACK);
        }
        return sb.toString();
    }

}
