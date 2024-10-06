package race.view;

import java.util.List;

import race.car.Car;

public class ResultView {

    private static final String FORWARD_STRING = "-";
    private static final String OUTPUT_DELIMITER = " : ";
    private static final String WINNER_DELIMITER = ",";

    public static void output(List<Car> cars) {
        for (Car car : cars) {
            carForwardPrint(car);
        }
        System.out.println();
    }

    private static void carForwardPrint(Car car) {
        System.out.print(car.getCarName() + OUTPUT_DELIMITER);
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print(FORWARD_STRING);
        }
        System.out.println();
    }

    public static void announceWinner(List<String> raceResult) {
        String winnersName = String.join(WINNER_DELIMITER, raceResult);
        System.out.println(winnersName + "가 최종 우승했습니다.");
    }
}
