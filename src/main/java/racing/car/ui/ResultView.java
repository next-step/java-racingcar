package racing.car.ui;

import racing.car.car.Car;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public static final String LINE = "-";

    public void outputView(List<Car> cars) {
        StringBuilder sb = new StringBuilder();

        for (Car car : cars) {
            sb.append(car.getName()).append(" : ");
            generateRepeatedLine(car.getPosition(), sb);
            System.out.println(sb.toString());
            sb.setLength(0);
        }

        System.out.println();
    }

    public void outputWinnerView(int max, List<Car> cars) {
        String winners = cars.stream()
                .filter(car -> car.isWin(max))
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println(winners + "가 최종 우승했습니다.");
    }

    private static void generateRepeatedLine(int repeatCount, StringBuilder outputBuilder) {
        for (int i = 0; i < repeatCount; i++) {
            outputBuilder.append(LINE);
        }
    }
}
