package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarTest {
  private Car car;
  @BeforeEach
  void init(){
    car = new Car(0);
  }

  @Test
  void carStartsAtZero(){
    assertThat(car.getPosition()).isEqualTo(0);
  }

  @ParameterizedTest
  @CsvSource({"4,true", "5,true", "0,false", "3,false"})
  void carGoIfMoreThan4(int randomValue, boolean expected){
    boolean result = car.isMove(randomValue);
    assertThat(result).isEqualTo(expected);
  }
}
