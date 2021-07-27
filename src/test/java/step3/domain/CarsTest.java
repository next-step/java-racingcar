package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

  @DisplayName("이름 개수와 차량의 개수는 동일해야한다")
  @Test
  void numberOf() {
    final List<Name> names = List.of(
        new Name("pobi"),
        new Name("crong"),
        new Name("honux")
    );
    Cars cars = new Cars(names);
    final int actual = cars.numberOf();

    assertThat(actual).isEqualTo(3);
  }
}