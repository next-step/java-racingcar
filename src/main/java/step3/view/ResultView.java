package step3.view;

import step3.Car;
import step3.Distance;

import java.util.List;

import static java.util.stream.Collectors.*;

public class ResultView {

    static {
        System.out.println("실행 결과");
    }

    public static void getRoundResult(List<Car> cars, String sign) {
        cars.stream()
                .map(Car::getDistance)
                .forEach(d -> printCountBySign(sign, d.getMileage()));
        System.out.println();
    }

    public static void getRoundResultWithName(List<Car> cars, String sign) {
        cars.stream()
                .forEach(c -> printCountBySignWithName(sign, c.getName().getName(), c.getDistance().getMileage()));
        System.out.println();
    }

    public static void printCountBySign(String sign, int repeatCount) {
        String result = "";
        for (int i = 0; i < repeatCount; i++) {
            result += sign;
        }
        System.out.println(result);
    }

    public static void printCountBySignWithName(String sign, String name, int repeatCount) {
        String result = "";
        for (int i = 0; i < repeatCount; i++) {
            result += sign;
        }
        System.out.println(name + " : "  + result);
    }

    public static void printWinner(List<Car> cars) {
        Distance distance = cars.stream()
                    .map(c -> c.getDistance())
                    .max((c1, c2) -> (c1.getMileage() > c2.getMileage()) ? 1 : (c1.getMileage() == c2.getMileage()) ? 0 : -1)
                    .get();

        String carNames = cars.stream()
                .filter(c -> c.getDistance().equals(distance))
                .map(c -> c.getName().getName())
                .collect(joining(", "));
        System.out.println(carNames + "가 최종 우승했습니다.");
    }
}
