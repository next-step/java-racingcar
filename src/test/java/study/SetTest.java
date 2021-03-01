package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2021/03/02.
 * @project java-racingcar
 * @description
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

  @DisplayName("요구사항1: size")
  @Test
  void size() {
    assertThat(numbers.size()).isEqualTo(3);
  }

  @DisplayName("요구사항2: contains")
  @Test
  void contains() {
    assertThat(numbers).contains(1);
    assertThat(numbers).contains(2);
    assertThat(numbers).contains(3);
  }

}
