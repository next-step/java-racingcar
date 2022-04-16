package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.domain.strategy.NameLengthValidationStrategy;
import racing.exception.CarNameUnsuitableException;

class CarNameTest {

  @ParameterizedTest
  @DisplayName("자동차 이름이 주어진대로 잘 생성되는지 확인")
  @ValueSource(strings = {"racer", "test", "hihi", "자동차"})
  void carNameTest(String name) {
    //given
    CarName carName = new CarName(name, new NameLengthValidationStrategy());

    //then
    assertThat(carName.getValue()).isEqualTo(name);
  }

  @Test
  @DisplayName("5글자 이상의 이름은 예외 발생 확인")
  void validExceptionTest() {
    assertThatThrownBy(() -> {
      new CarName("hihisososo", new NameLengthValidationStrategy());
    }).isInstanceOf(CarNameUnsuitableException.class);
  }
}