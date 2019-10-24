package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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

  @Test
  void size() {
    assertThat(numbers).hasSize(4);
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3})
  void contains(String no) {
    assertThat(numbers.contains(no)).isTrue();
  }

  @ParameterizedTest
  @CsvSource(value = {"1:true", "4:false"}, delimiter = ':')
  void contains(int no, boolean result) {
    assertThat(numbers.contains(no)).isEqualTo(result);
  }
}
