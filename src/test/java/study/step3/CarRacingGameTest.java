package study.step3;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.Test;

public class CarRacingGameTest {


  @Test
  public void carNumberInputTest() {
    String userMatchNumber = "5";
    InputStream in = new ByteArrayInputStream(userMatchNumber.getBytes());
    System.setIn(in);

    CarRacingGame carRacingGame = new CarRacingGame();
    int carCount = carRacingGame.getCarNumber();
    System.out.println(userMatchNumber);
    assertThat(carCount).isEqualTo(Integer.parseInt(userMatchNumber));
  }

}
