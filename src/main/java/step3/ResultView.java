package step3;

import java.util.List;

public class ResultView {

    public static final String DASH = "-";
    public static final String COLON = " : ";
    public static final String COMMA = ", ";
    public static final String FINAL_RESULT_MESSAGE = "%s가 최종 우승했습니다.";

    public static void result(List<Car> cars) {
        for (Car car : cars) {
            StringBuilder builder = new StringBuilder();
            builder.append(car + COLON);
            makeDash(car, builder);
            System.out.println(builder.toString());
        }
        System.out.println();
    }

    public static void finalResult(List<String> carNames) {
        StringBuilder builder = new StringBuilder();
        for (String carName : carNames) {
            makeComma(builder);
            builder.append(carName);
        }
        System.out.printf(FINAL_RESULT_MESSAGE + "%n", builder.toString());
    }

    private static void makeComma(StringBuilder builder) {
        if (builder.length() > 0) builder.append(COMMA);
    }

    private static void makeDash(Car car, StringBuilder builder) {
        for (int i = 0; i < car.getLocation(); i++) {
            builder.append(DASH);
        }
    }
}
