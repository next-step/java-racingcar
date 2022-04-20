package camp.nextstep.racingcar.view;

import camp.nextstep.racingcar.domain.CarRecord;
import camp.nextstep.racingcar.domain.RaceRecord;
import java.util.List;

public class ResultView {

  public static final String DISTANCE_MARK = "-";

  public static void print(List<RaceRecord> records) {
    System.out.println("실행 결과");
    for (RaceRecord record : records) {
      printCarRecord(record.getCarRecords());
      System.out.println();
    }
  }

  private static void printCarRecord(List<CarRecord> carRecords) {
    for (CarRecord carRecord : carRecords) {
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
