package study.racingcar.factory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import study.racingcar.domain.RandomInt;

public class RandomIntFactoryTest {

  @DisplayName("랜덤 값의 범위는 0이상, 10미만을 벗어날 수 없다.")
  @ParameterizedTest
  @CsvSource({"0,11", "-1,10", "-1,11", "-10,100"})
  public void randomIntFactory_throwException_outOfBound(int start, int end) {
    assertThatThrownBy(() -> new RandomIntFactory(start, end))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("랜덤 값은 범위에 맞게 생성된다.")
  @ParameterizedTest
  @CsvSource({"0,5", "1,6", "2,7", "3,8"})
  public void createRandomInt_RandomInt_inBound(int start, int end) {
    RandomIntFactory randomIntFactory = new RandomIntFactory(start, end);

    RandomInt randomInt = randomIntFactory.createRandomInt();
    assertThat(randomInt.isGreaterThan(start)).isTrue();
    assertThat(randomInt.isGreaterThan(end)).isFalse();
  }

}
