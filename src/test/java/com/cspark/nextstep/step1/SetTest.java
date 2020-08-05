package com.cspark.nextstep.step1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * <dl>
 *    <dt>Guide to JUnit 5 Parameterized Tests</dt>
 *    <dd>https://www.baeldung.com/parameterized-tests-junit-5</dd>
 * </dl>
 */
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

  @DisplayName("요구사항 1: size")
  @Test
  void size() {
    assertThat(numbers.isEmpty()).isFalse();
    assertThat(numbers)
        .as("중복 제거가 된 사이즈")
        .hasSize(3);
  }

  @DisplayName("요구사항 2-1: contains1")
  @Test
  void contains1() {
    assertThat(numbers.contains(1)).isTrue();
    assertThat(numbers.contains(2)).isTrue();
    assertThat(numbers.contains(3)).isTrue();
  }

  @DisplayName("요구사항 2-2: contains2")
  @ParameterizedTest
  @ValueSource(strings = {"1", "2", "3"})
  void contains2(int number) {
    assertThat(numbers.contains(number))
        .as("@ValueSource를 활용, 단 결과값 하나만 가능")
        .isTrue();
  }

  @DisplayName("요구사항 3")
  @ParameterizedTest
  @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
  void contains3(int number, boolean expected) {
    assertThat(numbers.contains(number))
        .as("@CsvSource를 활용, 값:결과으로 구성")
        .isEqualTo(expected);
  }

}
