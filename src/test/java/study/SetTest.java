package study;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

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
  @DisplayName("Set의 size() 메소드를 활용해 Set의 크기를 확인하는 테스트")
  void getSize() {
    int setSize = numbers.size();

    assertThat(setSize).isEqualTo(3);
    assertThat(numbers).hasSize(3);
  }

  @ParameterizedTest(name = "Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 테스트 (ValueSource 사용)")
  @ValueSource(ints = {1, 2, 3})
  void contains(int input) {
    assertThat(numbers.contains(input)).isTrue();
  }

  @ParameterizedTest(name = "Set의 contains() 메소드를 활용해 1, 2, 3, 4, 5의 값이 존재하는지를 확인하는 테스트 (CsvSource 사용)")
  @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"}, delimiter = ',')
  void contains2(int input, Boolean value) {
    assertThat(numbers.contains(input)).isEqualTo(value);
  }

}
