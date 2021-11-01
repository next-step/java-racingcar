import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
  @DisplayName("Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트")
  void setSize() {
    // when
    int size = numbers.size();

    // then
    assertThat(size)
            .isEqualTo(3);
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3})
  @DisplayName("Set이 요소들을 포함하고 있음을 확인하는 학습테스트")
  void setContainsElement(int element) {
    // then
    assertThat(numbers)
            .contains(element);
  }

  @ParameterizedTest
  @CsvSource(value = {"1, true", "2, true", "3, true", "4, false", "5, false"})
  @DisplayName("Set이 1, 2, 3은 포함하고 4, 5는 포함하지 않음을 확인하는 학습테스트")
  void setContainsElementOrNot(int element, boolean expected) {
    // when
    boolean contains = numbers.contains(element);

    // then
    assertEquals(expected, contains);
  }

}
