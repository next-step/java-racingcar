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

  @Test
  @DisplayName("랜덤값이 4이상이면 True를 반환한다.")
  void isTrue() {

    int random1 = 5;
    int random2 = 4;
    int random3 = 9;

    assertThat(CarRace.canMove(random1)).isTrue();
    assertThat(CarRace.canMove(random2)).isTrue();
    assertThat(CarRace.canMove(random3)).isTrue();

  }

  @Test
  @DisplayName("랜덤값이 4 미만이면 false를 반환한다.")
  void isFalse() {

    int random1 = 0;
    int random2 = 3;
    int random3 = 2;

    assertThat(CarRace.canMove(random1)).isFalse();
    assertThat(CarRace.canMove(random2)).isFalse();
    assertThat(CarRace.canMove(random3)).isFalse();

  }

}
