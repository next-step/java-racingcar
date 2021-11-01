import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;
import static org.assertj.core.api.Assertions.*;

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
  public void testSize() {
    assertThat(numbers.size()).isEqualTo(3);
  }

  @ParameterizedTest
  @ValueSource(ints = {1,2,3})
  void contains2(int num) {
    assertThat(numbers.contains(num)).isTrue();
  }

  @ParameterizedTest
  @CsvSource({"1,true", "2,true", "3,true", "4,false", "5,false"})
  void contains3(int num, boolean expected) {
    assertThat(numbers.contains(num)).isEqualTo(expected);
  }
}
