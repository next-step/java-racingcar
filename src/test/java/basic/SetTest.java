package basic;

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
  @DisplayName("Set의 크기를 테스트한다.")
  void 요구사항1() {
    assertThat(numbers.size()).isEqualTo(3);
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3})
  @DisplayName("Set에서 1,2,3값이 존재하는지 테스트한다.")
  void 요구사항2(int number) {
    assertThat(numbers).contains(number);
  }

  @ParameterizedTest
  @CsvSource(value = {"1,True", "2,True", "3,True", "4,False", "5,False"})
  @DisplayName("parm값에서 Set에 존재 유무에 따라 True/False를 리턴한다.")
  void 요구사항3(int number, boolean expected) {
    assertEquals(expected, numbers.contains(number));
  }

}
