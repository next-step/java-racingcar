package step03;

import org.junit.jupiter.api.Test;
import step03.calculatescore.CalculatorRandomScore;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Project : java-racingcar
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 12:50 오전
 */
class CalculatorRandomScoreTest {

    @Test
    public void randomScoreTest() {
        CalculatorRandomScore calculatorRandomScore = new CalculatorRandomScore();
        int result = calculatorRandomScore.calculateScore();

        assertThat(result).isLessThan(11);
    }
}