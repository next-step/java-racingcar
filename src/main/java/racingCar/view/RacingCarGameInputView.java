package racingCar.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class RacingCarGameInputView {

  public static List<String> getCarNames(BufferedReader reader) throws IOException {
    System.out.print("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).\n");
    String carNames = reader.readLine();
    return Arrays.stream(carNames.split(","))
        .map(String::strip)
        .collect(Collectors.toList());
  }


  public static int getMoveTryCnt(BufferedReader reader) throws IOException {
    System.out.print("시도할 회수는 몇 회 인가요?\n");
    String carCntStr = reader.readLine();
    return Integer.parseInt(carCntStr);
  }
}
