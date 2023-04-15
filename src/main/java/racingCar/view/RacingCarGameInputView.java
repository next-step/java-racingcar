package racingCar.view;

import java.io.BufferedReader;
import java.io.IOException;

public final class RacingCarGameInputView {

  public static int getCarCnt(BufferedReader reader) throws IOException {
    System.out.print("자동차 대수는 몇 대 인가요?\n");
    String carCntStr = reader.readLine();
    return Integer.parseInt(carCntStr);
  }

  public static int getMoveTryCnt(BufferedReader reader) throws IOException {
    System.out.print("시도할 회수는 몇 회 인가요?\n");
    String carCntStr = reader.readLine();
    return Integer.parseInt(carCntStr);
  }
}
