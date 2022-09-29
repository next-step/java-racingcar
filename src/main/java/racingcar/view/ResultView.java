package racingcar.view;

import java.util.List;
import racingcar.Car;
import racingcar.RacingRecord;
import racingcar.RoundCars;

public class ResultView {
    public static void printRoundRecord(RacingRecord roundRecord, String shape) {
        printStartMessage();
        List<RoundCars> roundCars = roundRecord.retrieveRecord();
        for (RoundCars roundCar : roundCars) {
            List<Car> cars = roundCar.retrieveCars();
            for (Car car : cars) {
                printPosition(car.getPosition(), shape);
            }
            print("");
        }
    }

    private static void printPosition(int position, String shape) {
        System.out.println(shape.repeat(position));
    }

    private static void print(String message) {
        System.out.println(message);
    }

    private static void printStartMessage() {
        System.out.println("실행 결과");
    }
}
