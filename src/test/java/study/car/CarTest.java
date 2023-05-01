package study.car;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
public class CarTest {
  @Test
  @DisplayName("정상적으로 Car 생성 (성공)")
  public void car_input_test1() throws Exception {

    new Car("12345");
  }

  @Test
  @DisplayName("자동차 이름이 null ㄴ인 경우 (실패)")
  public void car_input_test2() throws Exception {

    assertThrows(NullPointerException.class, () -> {
      new Car(null);
    });

  }

  @Test
  @DisplayName("글자수 5자리를 초과하는 경우.")
  public void car_input_test3() throws Exception {
    assertThrows(IllegalStateException.class, () -> {
      new Car("123456");
    });
  }
}
