package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Collections;
import org.junit.jupiter.api.Test;

class RaceTest {

    @Test
    void _0에서_9사이의_정수를_반환하는지_확인한다() {
        int[] check = new int[10];
        Race race = new Race(Collections.singletonList("car"), 7);
        for (int i = 0; i < 100; i++) {
            int randomNumber = race.getRandomNumber();
            check[randomNumber]++;
        }
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += check[i];
        }
        assertThat(sum).isEqualTo(100);
    }
}
