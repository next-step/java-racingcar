package racing.view;

import java.util.Map.Entry;
import racing.Cars;

public class ResultView {

  public static final String RESULT_START_MESSAGE = "실행 결과";
  public static final String CAR_TRACE = "-";

  public static void printResultTitle() {
    System.out.println(RESULT_START_MESSAGE);
  }

  public static void printTurnResult(Cars cars) {
    for (Entry<String, Integer> entry : cars.getLocationsByName().entrySet()) {
      System.out.println(entry.getKey() + " : " + CAR_TRACE.repeat(entry.getValue()));
    }
    System.out.println();
  }
}
