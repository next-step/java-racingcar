package step3.view;

import step3.domain.Car;

import java.util.List;

public class ResultView {
    private static final String RESULT_MESSAGE = "실행 결과";

    public static void printResultMessage() {
        System.out.println("");
        System.out.println(RESULT_MESSAGE);
    }

    public static void printCarLocation(List<Car> cars) {
        StringBuilder builder = new StringBuilder();
        cars.stream().forEach(car -> {
            for (int i = 0; i < car.getLocation(); i++) {
                builder.append("-");
            }
            System.out.println(builder.toString());
            builder.setLength(0);
        });
        System.out.println("\n");
    }
}
