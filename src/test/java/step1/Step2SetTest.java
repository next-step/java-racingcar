package step1;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class Step2SetTest {

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
  @DisplayName("단계 1 Set [요구사항 1] Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현")
  void 단계_1_Set_요구사항_1() {
    Assertions.assertEquals(3, numbers.size());
  }

  @DisplayName("단계 1 Set [요구사항 2] Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지 확인한다.")
  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3})
  void 단계_1_Set_요구사항_2(Integer input) {
    Assertions.assertTrue(numbers.contains(input));
  }

  @DisplayName("단계 1 Set [요구사항 3] Set.contains() 에 대해 입력 값에 따라 결과 값이 다른 경우에 대한 테스트를 구현한다.")
  @ParameterizedTest
  @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
  void 단계_1_Set_요구사항_3(int input, boolean result) {
    Assertions.assertEquals(result, numbers.contains(input));
  }
}
