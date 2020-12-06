package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomNumberTest {
    RandomNumber randomNumber = new RandomNumber();

    @Test
    @DisplayName("Random값 0에서9까지")
    public void randomNumberTest(){
        IntStream.range(0,9).forEach(i -> assertTrue(randomNumber.getRandom()<10));
    }

}