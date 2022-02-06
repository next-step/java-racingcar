package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.junit.jupiter.api.Test;

class RaceTest {

    @Test
    void _0에서_9사이의_정수를_반환하는지_확인한다() {
        int[] check = new int[10];
        for (int i = 0; i < 100; i++) {
            int randomNumber = Race.getRandomNumber();
            System.out.println(randomNumber);
            check[randomNumber]++;
        }
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += check[i];
        }
        assertThat(sum).isEqualTo(100);
    }
}
