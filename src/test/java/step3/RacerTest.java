package step3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

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

    Result result = racer.race();

    assertThat(result.getRoundResult(0).getCar(0).getScore()).isEqualTo(1);
    assertThat(result.getRoundResult(0).getCar(1).getScore()).isEqualTo(1);
    assertThat(result.getRoundResult(1).getCar(0).getScore()).isEqualTo(2);
    assertThat(result.getRoundResult(1).getCar(1).getScore()).isEqualTo(2);
    assertThat(result.getRoundResult(2).getCar(0).getScore()).isEqualTo(3);
    assertThat(result.getRoundResult(2).getCar(1).getScore()).isEqualTo(3);
  }

  @Test
  void 자동차가_전진하지_않는_경우() {
    racer = new Racer(2, 3, raceEvaluator);
    when(raceEvaluator.evaluate()).thenReturn(false);

    Result result = racer.race();

    assertThat(result.getRoundResult(0).getCar(0).getScore()).isEqualTo(0);
    assertThat(result.getRoundResult(0).getCar(1).getScore()).isEqualTo(0);
    assertThat(result.getRoundResult(1).getCar(0).getScore()).isEqualTo(0);
    assertThat(result.getRoundResult(1).getCar(1).getScore()).isEqualTo(0);
    assertThat(result.getRoundResult(2).getCar(0).getScore()).isEqualTo(0);
    assertThat(result.getRoundResult(2).getCar(1).getScore()).isEqualTo(0);
  }

  @Test
  void 혼재되어_전진하는_경우() {
    racer = new Racer(3, 2, raceEvaluator);
    when(raceEvaluator.evaluate())
        .thenReturn(true, false, true, false, false, true);

    Result result = racer.race();
    System.out.println(result);

    assertThat(result.getRoundResult(0).getCar(0).getScore()).isEqualTo(1);
    assertThat(result.getRoundResult(0).getCar(1).getScore()).isEqualTo(0);
    assertThat(result.getRoundResult(0).getCar(2).getScore()).isEqualTo(1);
    assertThat(result.getRoundResult(1).getCar(0).getScore()).isEqualTo(1);
    assertThat(result.getRoundResult(1).getCar(1).getScore()).isEqualTo(0);
    assertThat(result.getRoundResult(1).getCar(2).getScore()).isEqualTo(2);
  }
}
