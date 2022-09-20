package study;

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
  @DisplayName("numbers의 사이즈를 구하는 테스트")
  void getSize() {
    int result = numbers.size();
    assertThat(result).isEqualTo(3);
  }

  @ParameterizedTest
  @ValueSource(ints = {1,2,3})
  @DisplayName("값의 존재 확인")
  void contains(int number){
    assertThat(numbers.contains(number)).isTrue();
  }

  @ParameterizedTest
  @CsvSource({"1,true","2,true","3,true","4,false","5,false"})
  @DisplayName("값의 존재 여부에 따른 True ,False 반환")
  void True_False_존재여부(int number,Boolean expected){
    assertThat(numbers.contains(number)).isEqualTo(expected);
  }
}
