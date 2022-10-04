package racingcar.view;

import java.util.List;
import racingcar.Car;
import racingcar.RacingRecord;
import racingcar.RoundCars;

public class RacingResultView {

    private static final String SHAPE = "-";

    public static void printRoundRecord(RacingRecord racingRecord) {
        System.out.println("실행 결과");
        List<RoundCars> roundCars = racingRecord.retrieveRecord();
        for (RoundCars roundCar : roundCars) {
            List<Car> cars = roundCar.retrieveCars();
            for (Car car : cars) {
                printCar(car, SHAPE);
            }
            System.out.println();
        }
        printWinners(racingRecord.retrieveWinners());
    }

    private static void printWinners(List<String> winners) {
        String winnerNames = String.join(", ", winners);
        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }

    private static void printCar(Car car, String shape) {
        System.out.println(car.getName() + " : " + shape.repeat(car.getPosition()));
    }
}
