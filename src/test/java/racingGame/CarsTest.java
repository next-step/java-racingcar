package racingGame;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import javafx.util.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

  private Cars sampleCars;
  private String names;
  private ScoreGenerator scoreGenerator;

  @BeforeEach
  void setUp() {
    names = "a,b,c,d";
    this.sampleCars = Cars.of(names);
    this.scoreGenerator = new DummyScoreGenerator();
  }

  @Test
  @DisplayName("전체 이동 및 상태 확인")
  void moveAll() {
    this.sampleCars.movesCar(scoreGenerator);

    assertThat(this.sampleCars.extractFurthestPosition()).isEqualTo(1);
  }

  @Test
  @DisplayName("우승자 추출")
  void testExtractWinners() {
    this.sampleCars.movesCar(scoreGenerator);
    assertThat(this.sampleCars.extractWinners(this.sampleCars.extractFurthestPosition()))
        .isEqualTo(Arrays.asList("a", "c"));
  }

  @Test
  @DisplayName("현재 상태 출력 테스트(초기 상태)")
  void testCurrentStatusOnInitialStatus() {
    List<Pair<String, Integer>> result = this.sampleCars.getCarsStatus();
    List<Pair<String, Integer>> expected = new Vector<>(
        Arrays.asList(new Pair<>("a", 0), new Pair<>("b", 0), new Pair<>("c", 0),
            new Pair<>("d", 0)));

    assertThat(result).isEqualTo(expected);
  }

  @Test
  @DisplayName("현재 상태 출력 테스트(이동 상태)")
  void testMovedCarStatus() {
    this.sampleCars.movesCar(this.scoreGenerator);

    List<Pair<String, Integer>> result = this.sampleCars.getCarsStatus();
    List<Pair<String, Integer>> expected = new Vector<>(
        Arrays.asList(new Pair<>("a", 1), new Pair<>("b", 0), new Pair<>("c", 1),
            new Pair<>("d", 0)));

    assertThat(result).isEqualTo(expected);
  }

}
