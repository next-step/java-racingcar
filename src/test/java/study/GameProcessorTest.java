package study;

import static org.assertj.core.api.Assertions.*;

import com.GameProcessor;
import org.junit.jupiter.api.Test;


public class GameProcessorTest {
    @Test
    void getRandomValue() {
        GameProcessor processor = new GameProcessor();
        assertThat(processor.getRandomValue()).isGreaterThan(0).isLessThan(9);
    }

    @Test
    void isMovePossible() {
        GameProcessor processor = new GameProcessor();
        assertThat(processor.isMovePossible(3)).isFalse();
        assertThat(processor.isMovePossible(10)).isTrue();
    }
}
