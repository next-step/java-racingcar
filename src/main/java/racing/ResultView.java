package racing;

import java.util.List;

public class ResultView {

    private static final String DISTANCE_GRAPH = "-";
    private static final String ENTER = "\n";

    public static void printCarDistance(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(repeatString(DISTANCE_GRAPH, car.getPosition()));
        }
        System.out.print(ENTER);
    }

    public static void printResult() {
        System.out.println("실행 결과");
    }

    private static String repeatString(String str, long num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
}
