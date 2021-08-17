package step45.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TryNumTest {

  @ParameterizedTest(name = "생성 테스트 : {0}")
  @ValueSource(ints = {1, 2, 3, 4, 20})
  void createTest(int num) {
    //when
    TryNum tryNum = new TryNum(num);

    //then
    assertThat(tryNum).isEqualTo(new TryNum(num));
  }

  @ParameterizedTest(name = "잘못된 생성 테스트 : {0}")
  @ValueSource(ints = {-1, -2, -20})
  void invalidTest(int num) {
    //then
    assertThatIllegalArgumentException().isThrownBy(() -> {
      new TryNum(num);
    });
  }

  @Test
  void isFinishTest() {
    //given
    int num0 = 0;
    int num1 = 1;
    int num2 = 2;

    //when
    TryNum tryNum0 = new TryNum(num0);
    TryNum tryNum1 = new TryNum(num1);
    TryNum tryNum2 = new TryNum(num2);

    //then
    assertThat(tryNum0.isFinish()).isEqualTo(true);
    assertThat(tryNum1.isFinish()).isEqualTo(false);
    assertThat(tryNum2.isFinish()).isEqualTo(false);
  }

  @Test
  void decreaseTest() {
    //given
    int num = 3;
    TryNum tryNum = new TryNum(num);

    //when
    tryNum = tryNum.decrease();

    //then
    assertThat(tryNum).isEqualTo(new TryNum(num - 1));
  }
}