package race.view;

import domain.Car;
import java.util.List;

public class ResultView {

    private final static String END_OF_LINE = "\n";

    public static void start() {
        System.out.println("실행 결과");
    }

    public static void showProcess(List<Car> cars) {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car).append(END_OF_LINE);
        }
        System.out.println(sb);
    }
}
