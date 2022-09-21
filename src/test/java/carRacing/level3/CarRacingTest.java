package carRacing.level3;



import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarRacingTest {

  @Test
  @DisplayName("getRandomNum()함수는 0~9까지의 랜덤값을 생성해준다")
  void getRandomNum() {
    assertThat(CarRace.getRandomNum()).isLessThan(10);
  }

}
