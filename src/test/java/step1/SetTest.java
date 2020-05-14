package step1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
  @DisplayName("numbers Set의 사이즈를 확인")
  void getSetSize() {
    assertThat(numbers.size()).isEqualTo(3);
  }

  @Test
  @DisplayName("Set에 1,2,3이 존재하는지 확인")
  void checkContains() {
    assertThat(numbers.contains(1)).isTrue();
    assertThat(numbers.contains(2)).isTrue();
    assertThat(numbers.contains(3)).isTrue();
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3})
  @DisplayName("@ValueSource를 이용하여 Set에 1,2,3이 존재하는지 확인")
  void checkContinsUsingPram(int value) {
    assertThat(numbers.contains(value)).isTrue();
  }

  @ParameterizedTest
  @CsvSource({"1,true", "2,true", "3,true", "4,false", "5,false" })
  @DisplayName("@CsvSource를 이용하여 Set에 1,2,3이 존재하는지 확인")
  void checkContainsUsingCsv(int input, boolean expected) {
    boolean result = numbers.contains(input);
    assertEquals(expected, result);
  }

}
