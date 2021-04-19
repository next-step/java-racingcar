package step3.data;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.strategy.MoveStrategy;

public class CarTest {

  private Car car;

  @BeforeEach
  void setUp(){
    car = new Car();
  }

  @Test
  @DisplayName("값이 4이상일 경우 전진")
  public void moveTest() {
    car.move(new MoveStrategy());

    assertThat(car.getPosition()).isIn(0,1);
  }
}
