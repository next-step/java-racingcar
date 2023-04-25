package study.car;
import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.carrace.Race;
public class CarTest {
  @Test
  @DisplayName("각 자동차에 이름을 부여할 수 있다. 자동차 이름은 5자를 초과할 수 없다.")
  public void car_input_test() throws Exception {
    String str1 = "12345";
    String str2 = "123";
    String str3 = "1234";

    assertThrows(NullPointerException.class, () -> {
      new Car(null);
    });

    assertThrows(IllegalStateException.class, () -> {
      new Car("123456");
    });

    new Car(str1);
    new Car(str2);
    new Car(str3);
  }
}
