package car;

import static org.junit.jupiter.api.Assertions.assertTrue;

import car.util.RandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomGeneratorTest {

    @Test
    @DisplayName("Random Number가 0에서 9 사이 숫자인지 확인")
    void 랜덤_넘버_범위_확인() {
        int number1 = new RandomNumberGenerator().createNumber();
        assertTrue(number1 >= 0 && number1 < 10);
    }
}
