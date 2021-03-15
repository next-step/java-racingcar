package racingcar.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserInputValidatorTest {

  private static final UserInputValidator validator = new UserInputValidator();

  @Test
  @DisplayName("split 사이즈 값이 이상할 경우 익셉션이 발생하는가")
  public void throwIsNotProperlySplit() {
    //when
    IllegalArgumentException thrown = assertThrows(
        IllegalArgumentException.class,
        () -> validator.carNameValidation(",")
    );

    //then
    assertTrue(thrown.getMessage().contains("ERROR :"));
  }

  @Test
  @DisplayName("공백 값을 제거할 수 있는가")
  public void removeWhiteSpace() {
    //when
    List<String> expectedString = validator.carNameValidation("aaa    ");

    //then
    assertEquals("aaa", expectedString.get(0));
  }

  @Test
  @DisplayName("입력된 이름에 숫자 혹은 특수문자가 포함된 경우 익셉션이 발생하는가")
  public void throwIsNotContainAlphabet() {
    //when
    IllegalArgumentException thrown = assertThrows(
        IllegalArgumentException.class,
        () -> validator.carNameValidation("1234,*&^*&")
    );

    //then
    assertTrue(thrown.getMessage().contains("ERROR :"));
  }

  @Test
  @DisplayName("이름이 5자 초과를 하면 익셉션이 발생하는가")
  public void throwExceedMaximum() {
    //when
    IllegalArgumentException thrown = assertThrows(
        IllegalArgumentException.class,
        () -> validator.carNameValidation("aaaaaa,bbbbbbb")
    );

    //then
    assertTrue(thrown.getMessage().contains("ERROR :"));
  }

  @Test
  @DisplayName("진행 라운드를 숫자가 아닌 값을 입력할 경우 익셉션이 발생하는가")
  public void throwIsNotNumeric() {
    //when
    IllegalArgumentException thrown = assertThrows(
        IllegalArgumentException.class,
        () -> validator.inputRoundValidation("aaaaaa,bbbbbbb")
    );

    //then
    assertTrue(thrown.getMessage().contains("ERROR :"));
  }
}