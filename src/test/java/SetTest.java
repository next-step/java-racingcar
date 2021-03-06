import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SetTest {
  private Set<Integer> numbers;

  @BeforeEach
  public void setUp() {
    numbers = new HashSet<>();
    numbers.add(1);
    numbers.add(1);
    numbers.add(2);
    numbers.add(3);
  }

  @ParameterizedTest
  @ValueSource(ints = { 1, 2, 3 })
  // @MethodSource("generateNum")
  @DisplayName("set 의 size 메소드를 활용해서 set 의 크기를 확인하는 학습테스트를 구현한다.")
  void sizeTest(int num) {
    System.out.println(num);
    // assertThat(numbers.contains(1)).isTrue();
    // assertThat(numbers.contains(2)).isTrue();
    // assertThat(numbers.contains(3)).isTrue();
    assertThat(numbers.contains(num)).isTrue();
  }

  private static Stream<Arguments> generateNum() {
    return Stream.of(Arguments.of(1), Arguments.of(2), Arguments.of(3));
    // return null;
  }

  @ParameterizedTest
  @CsvSource(value = { "1:true", "true:false", "2:true", "3:true", "4:false", "5:false" }, delimiter = ':')
  @DisplayName("1, 2, 3 이 들어갈때 true 값을, true, 4, 5 값이 들어갈땐 false 값을 통과하는 테스트")
  void sizeTest2(Object obj, Boolean bool) {
    //
    // System.out.println("obj: " + obj);
    // System.out.println("bool: " + bool);
    // System.out.println("numbers.contains(obj): " + numbers.contains(obj));

    // true 값이 들어올 경우 exception
    if (!isInteger((String) obj)) {
      assertThatThrownBy(() -> {
        Integer.parseInt((String) obj);
      }).isInstanceOf(NumberFormatException.class);
      return;
    }
    int num = Integer.parseInt((String) obj);
    // System.out.println("num: " + num);
    assertEquals(numbers.contains(num), bool);
  }

  private Boolean isInteger(String str) {
    try {
      Integer.parseInt(str);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }
}
