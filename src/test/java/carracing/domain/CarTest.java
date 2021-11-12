package carracing.domain;

import carracing.domain.entity.Car;
import carracing.domain.entity.Number;
import carracing.domain.entity.Round;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarTest {

  private Car car;

  @BeforeEach
  void init() {
    car = new Car(new Round(new Number(4)));
  }

  @ParameterizedTest()
  @CsvSource(value = {"1:5", "1:10", "1:4", "1:3"}, delimiter = ':')
  @DisplayName("car를 생성시 생성으로 넘겨준 인자를 통해 정확히 생성됐는지 확인한다.")
  void constructTest(int chance, int round) {
    car = new Car(new Round(new Number(round)));

    assertThat(car.getNowStep()).isEqualTo(chance);
    assertThat(car.getRemainRound()).isEqualTo(round);
  }

  @Test
  @DisplayName("car 생성시 인자에 null을 입력했을 경우 Exception이 던져진다.")
  void constructWithExceptionTest() {
    assertThatIllegalArgumentException().isThrownBy(() -> {
      car = new Car(null);
    });
  }

}