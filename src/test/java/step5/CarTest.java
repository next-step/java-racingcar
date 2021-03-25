package step5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step5.model.Car;
import step5.model.Position;
import step5.strategy.Strategy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

  private Strategy testMovingStrategy(boolean flag) {
    return () -> flag;
  }

  @ParameterizedTest
  @DisplayName("제대로 생성하고 이름, 위치 등의 상태 정보를 반환할 수 있는지 확인")
  @CsvSource({"sley,1", "tango,2"})
  void makeCarTest(String carName, int location) {
    Car carA = new Car(carName);
    Car carB = new Car(carName, location);

    Assertions.assertAll(
      () -> assertThat(carA.showCarName()).isEqualTo(carName),
      () -> assertThat(carA.getPosition()).isEqualTo(new Position(0)),
      () -> assertThat(carB.showCarName()).isEqualTo(carA.showCarName()),
      () -> assertThat(carB.getPosition()).isEqualTo(new Position(location))
    );
  }

  @ParameterizedTest
  @DisplayName("작동 싸인에 따라 움직이는 지 확인")
  @CsvSource({"sley,true,1", "tango,false,0"})
  void moveOkTest(String carName, boolean flag, int result) {
    Car car = new Car(carName);
    Position position = new Position(result);
    assertThat(car.move(testMovingStrategy(flag)).getPosition()).isEqualTo(position);
  }
}
