package racingcar.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomNumberTest {

    RandomNumber randomNumber;

    @BeforeEach
    void setUp() {
        randomNumber = new RandomNumber();
    }

    @Test
    @DisplayName("랜덤 생성기 테스트")
    void randomNumberTest() {
        System.out.println(randomNumber.producedRandomNumber());
        System.out.println(randomNumber);
        System.out.println(randomNumber.producedRandomNumber());
        System.out.println(randomNumber);
    }
}