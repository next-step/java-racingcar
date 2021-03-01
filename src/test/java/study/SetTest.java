package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

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
  @DisplayName("Set의 크기를 확인하는 테스트")
  void size(){
    assertThat(numbers.size()).isEqualTo(3);
  }

  // Test Case 구현
  @ParameterizedTest
  @DisplayName("해당 숫자들이 포함되는지 테스트")
  @ValueSource(ints = {1,2,3})
  void contains(int number) {
    assertThat(numbers.contains(number)).isTrue();
  }

  @ParameterizedTest
  @DisplayName("포함 안되는 숫자가 나왔을 때 틀리다는 결과를 내는지 테스트")
  @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
  void containsFalse(int number, boolean expected){
    assertThat(numbers.contains(number)).isEqualTo(expected);
  }
}
