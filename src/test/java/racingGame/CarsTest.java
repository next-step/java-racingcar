package racingGame;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Vector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarsTest {

  private Cars sampleCars;
  private List<String> names;

  @BeforeEach
  void setUp() {
    names = new Vector<>();
    names.add("a");
    names.add("b");
    names.add("c");
    names.add("d");
    names.add("e");

    this.sampleCars = Cars.of(names);
  }

  @Test
  @DisplayName("Car의 갯수 확인")
  void CarsInitializedStatus() {
    assertThat(sampleCars.size()).isEqualTo(this.names.size());
  }

  @ParameterizedTest
  @ValueSource(ints = {0, 1, 2, 3, 4})
  @DisplayName("Car의 초기 상태 확인(위치)")
  void initialPositions(int location) {
    assertThat(this.sampleCars.get(location).getPosition()).isEqualTo(0);
  }

  @Test
  @DisplayName("Car들의 초기 상태 확인")
  void initialNames() {
    for (int i = 0; i < this.sampleCars.size(); i++) {
      assertThat(this.sampleCars.get(i).getName()).isEqualTo(names.get(i));
    }
  }
}
