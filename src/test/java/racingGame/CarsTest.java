package racingGame;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarsTest {

  private Cars sampleCars;
  private String names;

  @BeforeEach
  void setUp() {
    names = "a,b,c,d,e";
    this.sampleCars = Cars.of(names);
  }

  @Test
  @DisplayName("Car 의 갯수 확인")
  void CarsInitializedStatus() {
    assertThat(sampleCars.getNumCars()).isEqualTo(this.names.split(",").length);
  }

  @ParameterizedTest
  @ValueSource(ints = {0, 1, 2, 3, 4})
  @DisplayName("Car 의 초기 상태 확인(위치)")
  void initialPositions(int location) {
    assertThat(this.sampleCars.get(location).getPosition()).isEqualTo(0);
  }

  @Test
  @DisplayName("Car 들의 초기 상태 확인")
  void initialNames() {
    for (int i = 0; i < this.sampleCars.getNumCars(); i++) {
      assertThat(this.sampleCars.get(i).getName()).isEqualTo(names.split(",")[i]);
    }
  }
}
