package study;

import java.util.List;

public class ResultView {

    public static void racingResult(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(convertPositionToHyphen(car.getPosition()));
        }
        System.out.println();
    }

    public static String convertPositionToHyphen(int position) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            stringBuilder.append("-");
        }
        return stringBuilder.toString();
    }
}
