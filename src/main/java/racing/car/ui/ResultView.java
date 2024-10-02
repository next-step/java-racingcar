package racing.car.ui;

import racing.car.car.Car;

import java.util.List;

public class ResultView {

    public static final String LINE = "-";

    public void outputView(List<Car> cars) {
        StringBuilder sb = new StringBuilder();

        for (Car car : cars) {
            generateRepeatedLine(car.getPosition(), sb);
            System.out.println(sb.toString());
        }

        System.out.println();
    }

    private static void generateRepeatedLine(int repeatCount, StringBuilder outputBuilder) {
        for (int i = 0; i < repeatCount; i++) {
            outputBuilder.append(LINE);
        }
    }
}
