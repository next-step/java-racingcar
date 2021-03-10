package step33;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Random;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RandomGeneratorTest {

    private RandomGenerator randomGenerator;

    @BeforeAll
    void init() {
        randomGenerator = new RandomGenerator(new Random());
    }

    @DisplayName("getRandomNumber가 10미만의 값인지 테스트")
    @Test
    void getRandomNumberTest() {
        Assertions.assertTrue(randomGenerator.getRandomNumber() < 10);
    }

    @DisplayName("isOver가 true나 false인지 테스트")
    @ParameterizedTest
    @CsvSource(value =
            {"1:false",
                    "2:false",
                    "3:false",
                    "4:true",
                    "5:true",
                    "6:true",
                    "7:true",
                    "8:true",
                    "9:true"},
            delimiter = ':')
    void isOverTest(int number, boolean isOver) {
        Assertions.assertSame(randomGenerator.isOver(number), isOver);
    }
}
