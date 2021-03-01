package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @author choijaeyong on 2021/03/02.
 * @project java-racingcar
 * @description
 */
public class SetTest {

  private Set<Integer> numbers;

  @BeforeEach
  void setUp() {
    numbers = new HashSet<>();
    numbers.add(1);
    numbers.add(1);
    numbers.add(2);
    numbers.add(3);
  }

  @DisplayName("요구사항1: size")
  @Test
  void size() {
    assertThat(numbers.size()).isEqualTo(3);
  }

  @DisplayName("요구사항2: contains")
  @ParameterizedTest
  @ValueSource(ints = {1,2,3})
  void contains(int input) {
    assertThat(numbers).contains(input);
  }

  @DisplayName("요구사항3: CsvSource")
  @ParameterizedTest
  @CsvSource(value = {"1,2,3:true","4,5:false" }, delimiter = ':')
  void return_true_false(String input, String expected) {
    for (String strNum : input.split(",")) {
      assertThat(numbers.contains(Integer.parseInt(strNum)))
          .isEqualTo(Boolean.valueOf(expected));
    }
  }
}
