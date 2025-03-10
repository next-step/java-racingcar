package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
  @DisplayName("요구사항 1: set size() 확인")
  void testSetSize() {
    int numbersSize = 3;
    assertEquals(numbers.size(), numbersSize);
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3})
  @DisplayName("요구사항 2: set에 값이 존재하는지 확인")
  void testSetContains(int input) {
    boolean isContain = numbers.contains(input);
    assertTrue(isContain);
  }

  @ParameterizedTest
  @CsvSource(value={"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
  @DisplayName("요구사항 3: set에 값 존재여부 확인")
  void testSetContainsAll(int input, boolean expected) {
    boolean isContain = numbers.contains(input);
    assertEquals(isContain, expected);
  }
}