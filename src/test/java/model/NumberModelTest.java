package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.lang.reflect.InvocationTargetException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class NumberModelTest {

  private static Stream<Arguments> modelAndValues() {
    // given
    // Arguments.of(테스트 대상 클래스, 유효한 생성자 파라미터, 유효하지않은 파라미터)
    return Stream.of(
        Arguments.of(CarCount.class, 1, 0),
        Arguments.of(TryCount.class, 1, 0),
        Arguments.of(CarPosition.class, 1, -1)
    );
  }

  @ParameterizedTest(name = "{1}로 {0} 생성이 성공")
  @MethodSource("modelAndValues")
  void 모델_생성_성공(Class<? extends NumberModel> clazz, int validValue) {
    //then
    assertDoesNotThrow(
        // when
        () -> clazz.getDeclaredConstructor(int.class)
            .newInstance(validValue)
    );
  }

  @ParameterizedTest(name = "{2}로 {0} 생성이 실패")
  @MethodSource("modelAndValues")
  void 모델_생성_실패(Class<? extends NumberModel> clazz, int validValue, int invalidValue) {
    /*
     * 실제로는 IllegalArgumentException을 발생시키나, getDeclaredConstructor에서 이 Exception을
     * catch하여 InvocationTargetException을 발생시키기 때문에 getTargetException()으로
     * IllegalArgumentException을 검사한다.
     */
    try {
      clazz.getDeclaredConstructor(int.class).newInstance(invalidValue);
    } catch (InvocationTargetException e) {
      assertThat(e.getTargetException()).isInstanceOf(IllegalArgumentException.class);
    } catch (Exception ignored) {
      throw new AssertionError();
    }
  }
}
