package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingManager {
    private static final String WINNERS_STRING = "가 최종 우승했습니다.";

    private final Cars cars;
    private final int round;
    private final List<List<CarDto>> records;

    public RacingManager(Cars cars, int round) {
        this.cars = cars;
        this.round = round;
        records = new ArrayList<>();
        records.add(cars.getRecord());
    }

    public static RacingManager of(List<String> carNames, int round) {
        return new RacingManager(Cars.from(carNames), round);
    }

    public void playRacing() {
        for (int i = 0; i < round; i++) {
            cars.takeTurn();
            records.add(cars.getRecord());
        }

        printResult();
    }

    public void printResult() {
        System.out.println("실행 결과");
        printRecords();
        printWinners();
    }

    private void printRecords() {
        for (List<CarDto> record : records) {
            printCarRecord(record);
            System.out.println();
        }
    }

    private static void printCarRecord(List<CarDto> record) {
        for (CarDto carRecord : record) {
            System.out.println(carRecord.getName() + " : " + "-".repeat(carRecord.getDistance() + 1));
        }
    }

    private void printWinners() {
        System.out.println(String.join(",", cars.findWinnerNames()) + WINNERS_STRING);
    }
}
