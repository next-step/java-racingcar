package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomTest {

    private RandomNumberProvider mRandomNumberProvider;

    @BeforeEach
    void setUp() {
        mRandomNumberProvider = new RandomNumberProviderImpl(10);
    }

    @RepeatedTest(1000)
    void randomBoundTest() {
        assertThat(mRandomNumberProvider.getRandomNumber()).isBetween(0, 9);
    }
}
