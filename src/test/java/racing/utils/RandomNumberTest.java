package racing.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static racing.utils.RandomNumber.makeOneRandomNumber;

public class RandomNumberTest {
    @Test
    public void makeNumber() {
        int randomNumber = makeOneRandomNumber();

        assertThat(randomNumber).isBetween(0, 9);
    }
}
