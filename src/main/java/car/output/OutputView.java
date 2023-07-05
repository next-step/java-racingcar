package car.output;

import java.util.List;
import car.domain.Car;
import car.domain.Cars;

public final class OutputView {
    private static StringBuilder sb;

    public static void printResult() {
        System.out.println("실행 결과");
    }

    public static void printEachRaceResult(Cars cars) {
        sb = new StringBuilder();
        cars.getCars().stream().forEach(o ->
            sb.append(o.getName()).append(" : ").append("-".repeat(o.getPosition())).append("\n")
        );
        System.out.println(sb.toString());
    }

    public static void printWinner(List<Car> winner) {
        sb = new StringBuilder();
        winner.stream().map(Car::getName).forEach(s -> sb.append(s).append(" "));
        sb.append("가 최종 우승했습니다.");
        System.out.println(sb.toString());
    }
}