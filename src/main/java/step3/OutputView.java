package step3;

import java.util.List;

public class OutputView {
    private static final String RESULT_MENTION = "실행결과";
    private static final String PRESENT_MOVE = "-";

    public static void resultMention() {
        System.out.println(RESULT_MENTION);
    }

    public static void displayCarList(List<Car> carList) {
        for(Car car : carList) {
            displayCar(car);
        }
        System.out.println();
    }

    private static void displayCar(Car car) {
        for(int position = 0; position < car.getCurrentPosition(); position++) {
            System.out.print(PRESENT_MOVE);
        }
        System.out.println();
    }
}
