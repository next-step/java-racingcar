package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;

public class ResultView {
    public static final String COLON = " : ";
    public static final String HYPHEN = "-";
    public static final String COMMA_SPACE = ", ";

    public static void output(String msg){
        System.out.println(msg);
    }

    public static void resultOutput(Cars cars) {
        List<Car> carList = cars.getCars();
        for (Car car : carList) {
            System.out.println(car.name().value() + COLON + HYPHEN.repeat(car.distance().distance()));
        }
    }

    public static void winnerOutput(List<Car> carList) {
        String result = "";
        for (Car car : carList) {
            result += car.name().value();
            result += COMMA_SPACE;
        }
        result = removeLastComma (result);
        result += "가 최종 우승했습니다";

        System.out.println(result);
    }

    static String removeLastComma (String text) {
        if (text.endsWith(", ")) {
            return text.substring(0, text.length() - 2);
        }
        return text;
    }

}
