package racing;

import org.junit.jupiter.api.RepeatedTest;
import static org.assertj.core.api.Assertions.assertThat;

public class RandomGeneratorTest {
    @RepeatedTest(10)
    void getRandomNumber(){
        int number = RandomGenerator.getNumber();
        assertThat(number <= 9 && number >= 0).isTrue();
    }
}
