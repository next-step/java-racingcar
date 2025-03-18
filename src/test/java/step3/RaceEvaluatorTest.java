package step3;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class RaceEvaluatorTest {

  @Mock
  private Random random;

  private RaceEvaluator raceEvaluator;

  @BeforeEach
  void setUp() {
    openMocks(this);
    raceEvaluator = new RaceEvaluator(random);
  }

  @Test
  void 랜덤값이_4_이상이면_자동차가_전진한다() {
    when(random.nextInt(10)).thenReturn(4);
    assertTrue(raceEvaluator.evaluate());
  }

  @Test
  void 랜덤값이_4_미만이면_자동차가_전진하지_않는다() {
    when(random.nextInt(10)).thenReturn(3);
    assertFalse(raceEvaluator.evaluate());
  }
} 