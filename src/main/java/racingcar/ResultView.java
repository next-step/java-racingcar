package racingcar;

import java.util.List;

public class ResultView {
    public static final String COLON = " : ";
    public static final String HYPHEN = "-";
    public static final String COMMA = ", ";

    public static void output(String msg){
        System.out.println(msg);
    }

    public static void resultOutput(Cars cars) {
        List<Car> carList = cars.getCars();
        for (Car car : carList) {
            System.out.println(car.name() + COLON + HYPHEN.repeat(car.distance()));
        }
    }

    public static void winnerOutput(List<Car> carList) {
        String result = "";
        for (Car car : carList) {
            result += car.name();
            result += COMMA;
        }
        result = removeComma(result);
        result += "가 최종 우승했습니다";

        System.out.println(result);
    }

    static String removeComma(String text) {
        if (text.endsWith(", ")) {
            return text.substring(0, text.length() - 2);
        }
        return text;
    }

}
