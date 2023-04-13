package racingCar;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import racingCar.view.RacingCarGameInputView;

public class RacingCarGameApplication {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    final long carCnt = RacingCarGameInputView.getCarCnt(reader);
    final long moveTryCnt = RacingCarGameInputView.getMoveTryCnt(reader);

    RacingCarGame racingCarGame = new RacingCarGame(carCnt, moveTryCnt);
    racingCarGame.play();
    reader.close();
  }
}
