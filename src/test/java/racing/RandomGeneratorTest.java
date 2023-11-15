package racing;

import org.junit.jupiter.api.RepeatedTest;
import racing.generator.NumberGenerator;
import racing.generator.RandomGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomGeneratorTest {
    @RepeatedTest(10)
    void getRandomNumber(){
        NumberGenerator generator = new RandomGenerator();
        int number = generator.generate();
        assertThat(number <= 9 && number >= 0).isTrue();
    }
}
