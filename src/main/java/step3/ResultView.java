package step3;

import java.util.List;

public class ResultView {

    public static final String DASH = "-";
    public static final String COLON = " : ";

    public static void result(List<Car> cars) {
        for (Car car : cars) {
            StringBuilder builder = new StringBuilder();
            builder.append(car.getName() + COLON);
            makeDash(car, builder);
            System.out.println(builder.toString());
        }
        System.out.println();
    }

    private static void makeDash(Car car, StringBuilder builder) {
        for (int i = 0; i < car.getLocation(); i++) {
            builder.append(DASH);
        }
    }
}
