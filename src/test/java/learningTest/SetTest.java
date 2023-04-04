package learningTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.assertj.core.api.Assertions;
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
  @DisplayName("size 메서드를 통해 Set의 크기를 알 수 있다")
  void sizeTest() {
    assertThat(numbers.size()).isEqualTo(3);

    numbers.add(4);
    assertThat(numbers.size()).isEqualTo(4);
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3})
  @DisplayName("contains 메서드를 활용해 값이 존재하는지 확인할 수 있다")
  void containsTest(int target) {
    assertThat(numbers.contains(target)).isTrue();
  }

  @ParameterizedTest
  @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
  @DisplayName("contains 메서드는 목적 값이 존재하면 true, 존재하지 않으면 false를 반환한다")
  void containsTrueOrFalseTest(int target, boolean flag) {
    assertThat(numbers.contains(target)).isEqualTo(flag);
  }
}
