package study;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.in;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetCollectionTest {

  private Set<Integer> numbers =new HashSet<>();

  @BeforeEach
  void init() {
    numbers.add(1);
    numbers.add(2);
    numbers.add(3);
    numbers.add(4);
    numbers.add(5);
  }

  @Test
  @DisplayName("Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.")
  public void set1() throws Exception {
    int size = numbers.size();
    assertThat(numbers).isEqualTo(5);
  }

  @DisplayName("JUnit의 ParameterizedTest를 활용해 중복 코드를 제거해 본다.")
  @ParameterizedTest
  @ValueSource(ints = {1,2,3})
  void contains(int input) {
    assertThat(numbers.contains(input)).isTrue();
  }

  @DisplayName("요구사항 2는 contains 메소드 결과 값이 true인 경우만 테스트 가능하다. 입력 값에 따라 결과 값이 다른 경우에 대한 테스트도 가능하도록 구현한다.")
  @ParameterizedTest
  @CsvSource({
      "1, true",
      "-5, false",
      "0, false",
      "2, true",
  })
  void contains2(int input, boolean expected) {
    assertThat(this.isContains(input)).isEqualTo(expected);
  }

  private boolean isContains(int input) {
    return numbers.contains(input);
  }
}
