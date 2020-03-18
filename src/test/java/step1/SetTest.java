package step1;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {
  private static final int setSize = 3;

  private Set numbers;

  @BeforeEach
  void setUp() {
    numbers = new HashSet<>();
    numbers.add(1);
    numbers.add(1);
    numbers.add(2);
    numbers.add(3);
  }

  @Test
  void testSize() {
    assertThat(numbers).hasSize(setSize);
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3})
  void testContains1(int element) {
    assertThat(numbers.contains(element)).isTrue();
  }

  @ParameterizedTest
  @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"})
  void testContains2(String element, String existance) {
    assertThat(numbers.contains(Integer.parseInt(element)))
        .isEqualTo(Boolean.parseBoolean(existance));
  }
}
