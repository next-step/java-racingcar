package study.racinggame.view;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {

  @ParameterizedTest(name = "입력한 수에 따라 양수이면 true, 아니면 false 확인 테스트")
  @CsvSource(value = {"1:true", "7:true", "0:false", "-1:false"}, delimiter = ':')
  public void givenNumber_WhenValidateNumber_ThenTrueOrFalse(int input, boolean expected) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    assertThat(getIsPositive().invoke(null, input)).isEqualTo(expected);
  }

  private Method getIsPositive() throws NoSuchMethodException {
    Method method = InputView.class.getDeclaredMethod("isPositive", int.class);
    method.setAccessible(true);
    return method;
  }

  @ParameterizedTest(name = "양수 입력하는 경우 해당 양수 반환 테스트")
  @ValueSource(ints = {1, 2, 7})
  public void givenPositiveNumber_WhenValidateNumber_ThenPositiveNumber(int input) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    assertThat(getValidatedNumber().invoke(null, input)).isEqualTo(input);
  }

  @ParameterizedTest(name = "양수 아닌 수 입력하는 경우 IllegalArgumentException 발생 테스트")
  @ValueSource(ints = {-1, 0, -4})
  public void givenNegativeNumber_WhenValidateNumber_ThenIllegalArgumentException(int input) throws NoSuchMethodException, IllegalAccessException {
    try {
      getValidatedNumber().invoke(null, input);
    } catch (InvocationTargetException e) {
      assertThat(e.getTargetException().getClass()).isEqualTo(IllegalArgumentException.class);
    }
  }

  private Method getValidatedNumber() throws NoSuchMethodException {
    Method method = InputView.class.getDeclaredMethod("validatedNumber", int.class);
    method.setAccessible(true);
    return method;
  }
}
