package racingcar.behavior;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomMovingTest {
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
