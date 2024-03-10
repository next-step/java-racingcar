package view;

import domain.Car;
import java.util.List;

public class ResultView {

    public static void start() {
        System.out.println("실행 결과");
    }

    public static void showProcess(List<Car> cars) {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car).append("\n");
        }
        System.out.println(sb);
    }
}
