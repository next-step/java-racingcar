package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {
  private Set<Integer> numbers;

  @BeforeEach
  void setUp() {
    numbers = new HashSet<>(Arrays.asList(1, 1, 2, 3));
  }

  @Test
  @DisplayName("요구 사항1, Set Size 검증")
  void size() {
    assertThat(numbers.size()).isEqualTo(3);
    assertThat(numbers).hasSize(3);
  }

  @ParameterizedTest
  @DisplayName("요구 사항2, @ValueSource 어노테이션 학습 테스트")
  @ValueSource(ints = { 1, 2, 3 })
  void containsValueSourceAnnotation(int number) {
    assertThat(numbers.contains(number))
            .isTrue();
  }

  @ParameterizedTest
  @DisplayName("요구 사항2, @CsvSource 어노테이션 학습 테스트")
  @CsvSource(value = { "1:true", "2:true", "3:true", "4:false", "5:false" }, delimiter = ':')
  void containsCsvSourceAnnotation(int number, boolean expected) {
    assertThat(numbers.contains(number))
            .isEqualTo(expected);
  }
}
