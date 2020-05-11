package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SetCollectionTest {
  private Set<Integer> numbers;

  @BeforeEach
  void setUp() {
    numbers = new HashSet();
    numbers.add(1);
    numbers.add(1);
    numbers.add(2);
    numbers.add(3);
  }

  @DisplayName("Set Collection Size 확인")
  @Test
  void 요구사항_01 () {
    assertThat(numbers.size()).isEqualTo(3);
  }

  @DisplayName("Set Collection 값 확인")
  @ParameterizedTest
  @ValueSource(ints = { 1, 2, 3 })
  void 요구사항_02 (int n) {
    assertThat(numbers.contains(n)).isTrue();
  }

  @DisplayName("Set Collection 값의 존재 여부에 따라 True or False 확인 - contains method 활용")
  @ParameterizedTest
  @CsvSource(value = { "1,true", "2,true", "3,true", "4,false", "5,false" })
  void 요구사항_03 (int n, boolean expected) {
    assertEquals(expected, numbers.contains(n));
  }

  @DisplayName("Set Collection 값의 존재 여부에 따라 True or False - HashMap 활용")
  @ParameterizedTest
  @CsvSource(value = { "1,true", "2,true", "3,true", "4,false", "5,false" })
  void 요구사항_03_02 (int n, boolean expected) {
    assertEquals(expected, numbersContain(n));
  }

  boolean numbersContain (int n) {
    HashMap<Integer, Boolean> map = new HashMap<>();
    map.put(1, true);
    map.put(2, true);
    map.put(3, true);
    map.put(4, false);
    map.put(5, false);
    return map.get(n);
  }
}
