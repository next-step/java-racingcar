package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.ArrayList;
import java.util.List;

class RandomNumberGeneratorTest {

    List<Integer> numbers = new ArrayList<>();
    int number;

    @BeforeEach
    void setUp() {
        number = RandomNumberGenerator.generateRandomNumber();
        numbers.add(number);
    }

    @RepeatedTest(1000)
    void randomRangeTest() {
        Assertions.assertThat(numbers.stream().allMatch(number -> (number >= 0 && number <= 9))).isTrue();
    }

}