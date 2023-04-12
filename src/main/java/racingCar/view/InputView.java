package racingCar.view;

import java.io.BufferedReader;
import java.io.IOException;

public final class InputView {

  public static long getCarCnt(BufferedReader reader) throws IOException {
    System.out.println("자동차 대수는 몇 대 인가요?\n");
    String carCntStr = reader.readLine();
    return Long.parseLong(carCntStr);
  }

  public static long getMoveTryCnt(BufferedReader reader) throws IOException {
    System.out.println("시도할 회수는 몇 회 인가요?\n");
    String carCntStr = reader.readLine();
    return Long.parseLong(carCntStr);
  }
}
