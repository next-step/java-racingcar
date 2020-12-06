package step3.view;

import step3.domain.Car;

import java.util.List;

public class OutputView {

    private static final String DISPLAY = "-";

    public static void outputMessage() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void outputMessageAboutMove(List<Car> cars) {
        cars.forEach(car -> {
            StringBuilder builder = new StringBuilder();
            for (int i=0; i<car.getPosition(); i++) {
                builder.append(DISPLAY);
            }
            System.out.println(builder.toString());
        });
        System.out.println();
    }
}
