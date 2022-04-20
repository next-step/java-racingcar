package camp.nextstep.racingcar.view;

import camp.nextstep.racingcar.domain.Car;
import camp.nextstep.racingcar.domain.CarRecord;
import camp.nextstep.racingcar.domain.RaceRecord;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

  public static final String DISTANCE_MARK = "-";
  public static final String WINNER_DELIMITER = ", ";

  public static void print(List<RaceRecord> records) {
    System.out.println("실행 결과");
    for (RaceRecord record : records) {
      printCarRecord(record.getCarRecords());
      System.out.println();
    }
  }

  public static void printWinner(List<Car> winners) {
    String names = winners.stream()
        .map(Car::getName)
        .collect(Collectors.joining(WINNER_DELIMITER));
    System.out.println(names + "가 최종 우승했습니다.");
  }

  private static void printCarRecord(List<CarRecord> carRecords) {
    for (CarRecord carRecord : carRecords) {
      System.out.print(carRecord.getName() + " : ");
      printCarDistance(carRecord);
      System.out.println();
    }
  }

  private static void printCarDistance(CarRecord carRecord) {
    for (int i = 0; i < carRecord.getDistance(); i++) {
      System.out.print(DISTANCE_MARK);
    }
  }

}
