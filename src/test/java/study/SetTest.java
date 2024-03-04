package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
  private Set<Integer> numbers;

  @BeforeEach
  void setUp() {
    numbers = new HashSet<>();
    numbers.add(1);
    numbers.add(1);
    numbers.add(2);
    numbers.add(3);;
  }

  @Test
  void requirement_1() {
    Assertions.assertThat(numbers.size()).isEqualTo(3);
  }

  @ParameterizedTest
  @ValueSource(strings = {"1", "2", "3"})
  void requirement_2(Integer input) {
    Assertions.assertThat(numbers.contains(input)).isTrue();
  }

  @ParameterizedTest
  @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
  void requirement_3(Integer input, boolean expected) {
    Assertions.assertThat(numbers.contains(input)).isEqualTo(expected);
  }
}
