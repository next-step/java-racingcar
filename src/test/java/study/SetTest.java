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
  @DisplayName("set의 Size를 확인한다.")
  void setSizeTest() {
    assertThat(numbers.size()).isEqualTo(3);
  }

  @ParameterizedTest
  @DisplayName("set contains test.")
  @ValueSource(ints = {1, 2, 3})
  void contains(Integer number) {
    assertThat(numbers.contains(number)).isTrue();
  }

  @ParameterizedTest
  @DisplayName("set contains test.")
  @CsvSource(value = {"1:true", "2:true", "5:false", "4:false"}, delimiter = ':')
  void contains2(Integer number, boolean output) {
    assertThat(numbers.contains(number)).isEqualTo(output);
  }

}
