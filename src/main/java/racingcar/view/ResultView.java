package racingcar.view;

import racingcar.domain.Car;
import racingcar.dto.CarRecord;
import racingcar.dto.CarsRecord;
import racingcar.dto.RacingRecord;

import java.util.List;
import java.util.stream.Collectors;

public final class ResultView {
    private static final String COMMA = ",";
    private static final String COLON = " : ";
    private static final String POSITION_MARK = "-";
    private static final String RESULT_MESSAGE = "실행결과";
    private static final String FINAL_WON_MESSAGE = " 가 최종 우승했습니다.";
    private static final String NEW_LINE = System.lineSeparator();

    private ResultView() {
    }

    public static void printResultMessage() {
        System.out.println(NEW_LINE + RESULT_MESSAGE + NEW_LINE);
    }

    public static void printWinner(List<Car> winnerValues) {
        List<CarRecord> winnerCarNames = winnerValues.stream().map(Car::generateRecord).collect(Collectors.toList());
        List<String> winner = winnerCarNames.stream().map(CarRecord::getName).collect(Collectors.toList());
        System.out.println(NEW_LINE + String.join(COMMA, winner).concat(FINAL_WON_MESSAGE));
    }

    public static void printRacingCars(RacingRecord racingRecord) {
        List<CarsRecord> carsRecords = racingRecord.getRecords();
        for (CarsRecord carsRecord : carsRecords) {
            printCarsRound(carsRecord);
            System.out.println(NEW_LINE);
        }
    }

    private static void printCarsRound(CarsRecord carsRecord) {
        List<CarRecord> values = carsRecord.getValues();
        for (CarRecord value : values) {
            printCarPosition(value);
        }
    }

    private static void printCarPosition(CarRecord carRecord) {
        System.out.print(carRecord.getName() + COLON);
        System.out.println(POSITION_MARK.repeat(carRecord.getPosition()));
    }
}
