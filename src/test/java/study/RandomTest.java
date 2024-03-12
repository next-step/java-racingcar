package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import race.RaceRule;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomTest {

    @DisplayName("랜덤값을 1로 고정시켜 줬을 때 1을 반환한다")
    @Test
    void randomIsOne() {
        RaceRule raceRule = new RaceRule(() -> 1);
        assertThat(raceRule.generate()).isEqualTo(1);
    }

    @DisplayName("난수를 반환한다")
    @Test
    void randomIs() {
        RaceRule raceRule = new RaceRule(() -> {
            Random random = new Random();
            return random.nextInt(10);
        });
        assertThat(raceRule.generate()).isBetween(0, 10);
    }
}
