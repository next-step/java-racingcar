import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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
  @DisplayName("Set 값의 크기는 3이다.")
  public void setSizeCheck() {
    assertThat(this.numbers.size()).isEqualTo(3);
  }


  @ParameterizedTest
  @DisplayName("Set 값은 1,2,3이다.")
  @ValueSource(ints = {1, 2, 3})
  public void isContains(int num) {
    boolean contain = this.numbers.contains(num);
    assertThat(contain).isTrue();
  }

  @ParameterizedTest
  @DisplayName("Set 값은 1,2,3을 포함하고, 4,5를 제외한다")
  @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
  public void isContainWithFalseTest(int num, boolean expect) {
    boolean contain = this.numbers.contains(num);
    assertThat(contain).isEqualTo(expect);
  }

}

