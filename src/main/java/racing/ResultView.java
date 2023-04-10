package racing;

import java.util.List;

public class ResultView {

    private static final String DISTANCE_GRAPH = "-";

    public static void printResult(List<Car> cars) {

        System.out.println("실행 결과");
        for (Car car : cars) {
            System.out.println(repeatString(DISTANCE_GRAPH, car.getPosition()));
        }

    }

    private static String repeatString(String str, long num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
}
