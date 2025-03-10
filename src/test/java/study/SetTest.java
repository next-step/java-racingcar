package study;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
  @DisplayName("요구사항1: Set의 size 메소드는 Set에 포함된 원소의 개수를 반환한다")
  void size() {
    int size = numbers.size();
    assertThat(size).isEqualTo(3);
  }

  @ParameterizedTest
  @CsvSource({"1", "2", "3"})
  @DisplayName("요구사항2: Set의 contains 메소드는 Set에 특정 원소가 포함되어 있는지 여부를 반환한다")
  void contains(Integer number) {
    boolean contains = numbers.contains(number);
    assertThat(contains).isTrue();
  }

  @ParameterizedTest
  @CsvSource({
      "1 | true",
      "2 | true",
      "3 | true",
      "4 | false",
      "5 | false"})
  @DisplayName("요구사항3: Set의 contains 메소드는 Set에 포함되지 않은 원소가 주어지면 false를 반환한다")
  void contains(Integer number, boolean expected) {
    boolean contains = numbers.contains(number);
    assertThat(contains).isEqualTo(expected);
  }
}
