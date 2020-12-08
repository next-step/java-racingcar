package step3.view;

import step3.Car;

import java.util.List;

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
}
