package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarNameTest {
  @Test
  @DisplayName("CarName이 제대로 생성되는가")
  public void create() {
    //given
    //when
    CarName name = new CarName("aaa");

    //then
    assertEquals(new CarName("aaa"), name);
  }

  @ParameterizedTest
  @ValueSource(strings = {"," , "1234,*&^*&", "aaaaaa,bbbbbbb"})
  @DisplayName("CarName이 허용하지 않은 문자에 대해서 제대로 익셉션이 발생하는가")
  public void valid(String notValidateString) {
    //given
    //when
    //then
    assertThrows(IllegalArgumentException.class, () -> new CarName(notValidateString));
  }

}
