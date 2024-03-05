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
  @DisplayName("[요구사항1] Set의 크기를 확인")
  void getSize(){
    // when
    int size = numbers.size();

    // then
    assertThat(size).isEqualTo(4);
  }


  @ParameterizedTest(name = "{index} : element={arguments}")
  @ValueSource(ints = {1, 2, 3})
  @DisplayName("[요구사항2] Set의 원소가 있는지 확인")
  void contains(int element){
    // when
    boolean result = numbers.contains(element);

    // then
    assertThat(result).isTrue();
  }

  @ParameterizedTest(name = "{index} : element {0} contains {1}")
  @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
  @DisplayName("[요구사항3] Set의 원소가 있는지 확인")
  void toLowerCase_ShouldGenerateTheExpectedLowercaseValue(Integer input, boolean expected) {
    boolean result = numbers.contains(input);
    assertThat(result).isEqualTo(expected);
  }

}
