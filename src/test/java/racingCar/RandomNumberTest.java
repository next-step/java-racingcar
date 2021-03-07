package racingCar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class RandomNumberTest {

  @DisplayName("0~9 난수생성")
  @RepeatedTest(value = 50)
  void createRandomNumber() {
    int randomNumber = RandomNumber.create();
    assertThat(randomNumber).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(9);
  }

}
