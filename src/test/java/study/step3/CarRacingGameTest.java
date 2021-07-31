package study.step3;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarRacingGameTest {


  CarRacingGame carRacingGame;


  @BeforeEach
  private void beforeTest() {
    carRacingGame = new CarRacingGame();
  }

  @Test
  public void carNumberInputTest() {
    String userMatchNumber = "5";
    InputStream in = new ByteArrayInputStream(userMatchNumber.getBytes());
    System.setIn(in);

    int carCount = carRacingGame.getCarNumber();
    System.out.println(userMatchNumber);
    assertThat(carCount).isEqualTo(Integer.parseInt(userMatchNumber));
  }

  @Test
  public void carRacingGameRepeatNumberInputTest() {
    String userMatchNumber = "5";
    InputStream in = new ByteArrayInputStream(userMatchNumber.getBytes());
    System.setIn(in);

    int carCount = carRacingGame.getRacingGameRepeatNumber();
    System.out.println(userMatchNumber);
    assertThat(carCount).isEqualTo(Integer.parseInt(userMatchNumber));
  }

//  자동차 이동 기능

  @Test
  public void carMovingGoTest() {

    carRacingGame.setCars(5);
    carRacingGame.setRacingGameRepeatNumber(5);


    List carStatusBeforeMove = carRacingGame.getRacingGameCars();

    int movedCarCount = carRacingGame.move();

    List carStatusAfterMove = carRacingGame.getRacingGameCars();

    int movedCarCountCalced = 0;
    for (int i = 0; i < carStatusBeforeMove.size(); i++) {
      movedCarCountCalced += calculateMovedCarNum(carStatusBeforeMove, carStatusAfterMove, i);
    }

    assertThat(movedCarCount).isEqualTo(movedCarCountCalced);
  }

  private int calculateMovedCarNum(List carStatusBeforeMove, List carStatusAfterMove, int i) {
    int movecCarNum = 0;
    if (carStatusBeforeMove.get(i) == carStatusAfterMove.get(i)) {
      movecCarNum = 1;
    }
    return movecCarNum;
  }


}
