package racing.ui;

import racing.Car;
import racing.Cars;

import java.util.List;

public class ResultView {

    private static final String FORWARD_MARK = "-";

    public static void output(int numberOfParticipationTry, Cars cars) {
        printStart();

        for (int i = 0; i < numberOfParticipationTry; i++) {
            printResult(cars);
        }
    }

    private static void printStart() {
        System.out.println();
        System.out.println("실행결과");
    }

    private static void printResult(Cars cars) {
        for (Car car : cars.getCars()) {
            StringBuilder stringBuilder = new StringBuilder();
            car.movePosition();
            for (int i = 0; i < car.getCarPosition(); i++) {
                stringBuilder.append(FORWARD_MARK);
            }
            System.out.println(stringBuilder.toString());
        }

        System.out.println();
    }

}
