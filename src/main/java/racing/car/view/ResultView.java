package racing.car.view;

import racing.car.domain.Car;
import racing.car.model.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public static final String LINE = "-";

    public void outputView(Cars cars) {
        StringBuilder sb = new StringBuilder();

        for (Car car : cars.getCars()) {
            sb.append(car.getName()).append(" : ");
            generateRepeatedLine(car.getPosition(), sb);
            System.out.println(sb.toString());
            sb.setLength(0);
        }

        System.out.println();
    }

    public void outputWinnerView(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::toString)
                .collect(Collectors.joining(","));

        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }

    private static void generateRepeatedLine(int repeatCount, StringBuilder outputBuilder) {
        for (int i = 0; i < repeatCount; i++) {
            outputBuilder.append(LINE);
        }
    }
}
