package Racing.car;

import static org.assertj.core.api.Assertions.assertThat;

import Racing.stage.Stage;
import Racing.type.RacingNumber;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarListTest {

  @Test
  @DisplayName("모든 자동차를 이동할수 있습니다.")
  void moveAllCar() {
    //given
    CarList carList = new CarList(
        new RacingNumber(3).generateInstanceList(Car.class)
    );
    Stage stage = new Stage();
    //when
    carList.moveAllCar(stage);
    List<RacingNumber> racingNumbers = carList.displayCarDistance();
    //then
    assertThat(racingNumbers.size()).isEqualTo(3);
  }

}