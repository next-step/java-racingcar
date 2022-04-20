package camp.nextstep.calculator.collection;

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

  @Test
  @DisplayName("[요구사항1] Set 크기를 조회한다.")
  public void hasSize() {
    assertThat(numbers).hasSize(3);
  }

  @DisplayName("[요구사항2] Set 입력값이 포함되어있는지 확인한다.")
  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3})
  public void contains(int input) {
    assertThat(numbers.contains(input)).isTrue();
  }

  @DisplayName("[요구사항3] Set 입력값이 포함되어있는지 확인한다.")
  @ParameterizedTest
  @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"})
  public void contains2(int input, boolean expected) {
    assertThat(numbers.contains(input)).isEqualTo(expected);
  }

}
