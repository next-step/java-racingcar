package Racing.stage;

import static org.assertj.core.api.Assertions.assertThat;

import Racing.car.Car;
import Racing.car.CarList;
import Racing.type.RacingNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StageTest {

  @Test
  @DisplayName("Stage 에 맞게 자동차를 전진 또는 멈출 수 있다.")
  public void testMoveCars() {
    //given
    CarList inputCarList = new CarList(
        new RacingNumber(3).generateInstanceList(Car.class)
    );
    Stage stage = new Stage();

    //when
    CarList outCarList = stage.moveCars(inputCarList);
    //then
    assertThat(outCarList.toString()).isNotEmpty();
  }

}