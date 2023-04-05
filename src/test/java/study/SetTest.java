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

  @DisplayName("assertj의 hasSize를 사용하여 Set의 크기를 확인한다.")
  @Test
  void hasSize_True_IfInputSetSize() {
    assertThat(numbers).hasSize(3);
  }

  @DisplayName("assertj의 contains를 사용하여 해당 값의 존재를 확인한다. (ValueSource 활용 테스트)")
  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3})
  void contains_True_IfExistingValue(int input) {
    assertThat(numbers).contains(input);
  }

  @DisplayName("Set의 contains를 사용하여 해당 값의 존재를 확인한다. (CsvSource 활용 테스트)")
  @ParameterizedTest
  @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
  void contains_TrueOrFalse_IfExistingOrNonExistingValue(int input, boolean expected) {
    assertThat(numbers.contains(input)).isEqualTo(expected);
  }
}
