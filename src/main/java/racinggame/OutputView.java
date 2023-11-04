package racinggame;

import java.util.List;

public class OutputView {

    public static final String OUTPUT_CAR_POSITION = "-";

    public void printRacing(List<Car> cars) {
        System.out.println();
        System.out.println("실행 결과");
        for (Car car : cars) {
            StringBuilder sb = new StringBuilder();
            printCarPosition(car, sb);
        }
    }

    private static void printCarPosition(Car car, StringBuilder sb) {
        for (int i = 0; i < car.getPosition(); i++) {
            sb.append(OUTPUT_CAR_POSITION);
        }
        System.out.println(sb);
        sb.setLength(0);
    }

}
