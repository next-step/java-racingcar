package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import racingcar.car.Car;
import racingcar.car.strategy.MovingStrategy;
import racingcar.car.strategy.RandomNumMovingStrategy;


public class CarTest {

  @Mock
  MovingStrategy movingStrategy;

  @Test
  @DisplayName("자동차의 시작 위치는 항상 0이다.")
  public void carFirstPositionTest() {
    Car car = new Car(new RandomNumMovingStrategy(), "CarName");
    int position = car.getPosition();
    assertThat(position).isEqualTo(0);
  }

  @ParameterizedTest
  @DisplayName("자동차는 한칸씩 이동한다")
  @ValueSource(ints = {1 ,3 ,5 ,10})
  public void carMoveOne(int moveCount) {
    this.movingStrategy = mock(MovingStrategy.class);
    when(this.movingStrategy.isCanMove()).thenReturn(true);

    Car car = new Car(this.movingStrategy, "CarName2");
    for(int i = 0 ; i < moveCount ; ++i) {
      car.tryMove();
    }
    assertThat(car.getPosition()).isEqualTo(moveCount);
  }

  @ParameterizedTest
  @DisplayName("자동차는 전진 시도보다 많이 갈수 없다.")
  @ValueSource(ints = {5, 1, 9})
  public void carMoveForward(int distance) {
    Car car = new Car(new RandomNumMovingStrategy(), "CarName");
    for (int i = 0; i < distance; ++i) {
      car.tryMove();
    }
    int position = car.getPosition();
    assertThat(position).isLessThanOrEqualTo(distance);
  }
}
