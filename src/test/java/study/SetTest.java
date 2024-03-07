package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

  @DisplayName("사이즈 확인")
  @Test
  void getSizeTest() {
    assertThat(numbers).size().isEqualTo(3);
  }

  @DisplayName("@ParameterizedTest를 활용하여 중복코드 제거 후 test")
  @ParameterizedTest
  @ValueSource(ints = {1,2,3})
  void containsTest(int input) {
    assertThat(numbers.contains(input)).isTrue();
  }

  @DisplayName("@CsvSource 활용하여 예상값과 매칭하여 test")
  @ParameterizedTest
  @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
  void csvTest(String input, String expected) {
    Integer input2Integer = Integer.valueOf(input);
    Boolean expected2Boolean = Boolean.valueOf(expected.toLowerCase());

    assertThat(numbers.contains(input2Integer)).isEqualTo(expected2Boolean);
  }

  @DisplayName("@CsvSource 활용하여 예상값과 매칭하여 test - 파라미터로 type으로 받아서 test")
  @ParameterizedTest
  @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
  void csvTestWithInputType(int input, boolean expected) {
    assertThat(numbers.contains(input)).isEqualTo(expected);
  }
}
