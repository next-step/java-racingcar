package step3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class RacerTest {

  @Mock
  private RaceEvaluator raceEvaluator;

  private Racer racer;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void 모든_자동차가_전진하는_경우() {
    racer = new Racer(2, 3, raceEvaluator);
    when(raceEvaluator.evaluate()).thenReturn(true);

    Map<Integer, int[]> result = racer.race();

    assertThat(result.get(0)).isEqualTo(new int[]{1, 1});
    assertThat(result.get(1)).isEqualTo(new int[]{2, 2});
    assertThat(result.get(2)).isEqualTo(new int[]{3, 3});
  }

  @Test
  void 자동차가_전진하지_않는_경우() {
    racer = new Racer(2, 3, raceEvaluator);
    when(raceEvaluator.evaluate()).thenReturn(false);

    Map<Integer, int[]> result = racer.race();

    assertThat(result.get(0)).isEqualTo(new int[]{0, 0});
    assertThat(result.get(1)).isEqualTo(new int[]{0, 0});
    assertThat(result.get(2)).isEqualTo(new int[]{0, 0});
  }

  @Test
  void 혼재되어_전진하는_경우() {
    racer = new Racer(3, 2, raceEvaluator);
    when(raceEvaluator.evaluate())
        .thenReturn(true)   // 첫 번째 자동차 전진 (1라운드)
        .thenReturn(false)  // 두 번째 자동차 멈춤 (1라운드)
        .thenReturn(true)   // 세 번째 자동차 전진 (1라운드)
        .thenReturn(false)  // 첫 번째 자동차 멈춤 (2라운드)
        .thenReturn(false)  // 두 번째 자동차 멈춤 (2라운드)
        .thenReturn(true);  // 세 번째 자동차 전진 (2라운드)

    Map<Integer, int[]> result = racer.race();

    assertThat(result.get(0)).isEqualTo(new int[]{1, 0, 1});  // 1라운드 결과
    assertThat(result.get(1)).isEqualTo(new int[]{1, 0, 2});  // 2라운드 결과
  }
}
