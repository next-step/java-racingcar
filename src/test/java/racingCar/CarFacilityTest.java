package racingCar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarFacility;

public class CarFacilityTest {

  @Test
  @DisplayName("차량 대수가 3대일 때 리스트 길이")
  public void countCarNum() {
    CarFacility carFacility = new CarFacility();
    List<Car> carList = carFacility.buildCar(3);
    assertThat(carList.size()).isEqualTo(3);
  }

}
