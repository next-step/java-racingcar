package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.stream.IntStream;

import racingcar.behavior.RandomNumber;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomMovingTest {
//    @DisplayName("0 부터 양의정수 입력값 이하의 랜덤 정수값을 반환하는지 테스트")
//    @ParameterizedTest
//    @ValueSource(ints = {3, 10, 9, 100})
//    public void shakeRandomBoundTest (int input) {
//        int result = new RandomMovingStrategy().random();
//        assertThat(result).isBetween(0, input + 1);
//    }

    @DisplayName("0부터 양의 정수 입력값 이하의 랜덤 정수값을 반환 여부")
    @ParameterizedTest
    @CsvSource(value = {"10:0:9", "15:0:14"}, delimiter = ':')
    public void randomBoundTest(int boundNumber, int min, int max) {
        int start = 0;
        int end = 10000;
        RandomNumber randomNumber = new RandomNumber(boundNumber);
        IntStream.range(start, end).forEach(index -> assertThat(randomNumber.getBoundNumber()).isBetween(min, max));
    }

}
