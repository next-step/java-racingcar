package stringsplitter;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetCollectionTest {
  private Set<Integer> numbers;

  @BeforeEach
  void setUp() {
    numbers = new HashSet<>();
    numbers.add(1);
    numbers.add(1);
    numbers.add(2);
    numbers.add(3);
  }

  @DisplayName("Test size method of Set")
  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3})
  void checkSetSizeMethod(int targetNumber) {
    assertThat(numbers.contains(targetNumber)).isTrue();
  }

  @DisplayName("Test size method of Set")
  @ParameterizedTest
  @CsvSource(value = {"1: true", "2: true", "3: true", "4: false", "5: false", "6: false"}, delimiter = ':')
  void checkSetSizeMethodWithMixingInvalid(int targetNumber, boolean result) {
    assertThat(numbers.contains(targetNumber)).isEqualTo(result);
  }
}
