package model;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.lang.reflect.InvocationTargetException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ImmutableNumberModelTest {

  private static Stream<Arguments> modelAndValuesToTest() {
    return Stream.of(
        Arguments.of(CarCount.class, 1, 0),
        Arguments.of(TryCount.class, 1, 0),
        Arguments.of(CarPosition.class, 1, -1)
    );
  }

  @ParameterizedTest
  @MethodSource("modelAndValuesToTest")
  void 모델_생성_성공(Class<? extends NumberModel> clazz, int validValue) {
    assertDoesNotThrow(() -> clazz.getDeclaredConstructor(int.class).newInstance(validValue));
  }

  @ParameterizedTest
  @MethodSource("modelAndValuesToTest")
  void 모델_생성_실패(Class<? extends NumberModel> clazz, int validValue, int invalidValue) {
    // 실제로는 IllegalArgumentException을 발생시키나, getDeclaredConstructor에서 이 Exception을 catch하여
    // InvocationTargetException을 발생시킨다.
    assertThrows(
        InvocationTargetException.class,
        () -> clazz.getDeclaredConstructor(int.class).newInstance(invalidValue)
    );
  }
}
