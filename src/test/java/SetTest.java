import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {
  private Set<Integer> numbers;
  @BeforeEach
  public void setUp() {
    numbers = new HashSet<>();
    numbers.add(1);
    numbers.add(2);
    numbers.add(3);
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3})
  void _1_2_3을_가진다(int value) {
    assertThat(numbers).contains(value);
  }

  @ParameterizedTest
  @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
  void csvsource로_구성되어있다(int value, boolean expected) {
    assertThat(numbers.contains(value)).isEqualTo(expected);
  }

  @Test
  void check_set_size(){
    assertThat(numbers).hasSize(3);
  }
}
