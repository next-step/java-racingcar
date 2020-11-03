package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;
import step4.util.RandomGenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockStatic;

@DisplayName("레이싱 전략 테스트")
public class RandomRacingStrategyTest {
    @DisplayName("4이상일 경우에 자동차를 움직임")
    @ParameterizedTest(name = "랜덤값: {0} -> 자동차 position: {1}")
    @CsvSource(value = {"0:0", "1:0", "2:0", "3:0", "4:1", "5:1", "6:1", "7:1", "8:1", "9:1"}, delimiter = ':')
    public void moveWithRandom(double randomValue, Integer expectedPosition) {
        try (MockedStatic<RandomGenerator> mocked = mockStatic(RandomGenerator.class)) {
            mocked.when(() -> RandomGenerator.getRandomLessThan(10)).thenReturn(randomValue);
            Car car = new Car("");
            new RandomRacingStrategy().move(car);

            Integer position = car.getFinalRecord().getRecord();

            assertThat(position).isEqualTo(expectedPosition);
        }
    }

    @DisplayName("항상 자동차 움직임 기록")
    @ParameterizedTest
    @CsvSource(value = {"0:1", "1:1", "2:1", "3:1", "4:1", "5:1", "6:1", "7:1", "8:1", "9:1"}, delimiter = ':')
    public void moveWithRecordAlways(double randomValue, Integer expectedRecordCount) {
        try (MockedStatic<RandomGenerator> mocked = mockStatic(RandomGenerator.class)) {
            mocked.when(() -> RandomGenerator.getRandomLessThan(10)).thenReturn(randomValue);
            Car car = new Car("");
            new RandomRacingStrategy().move(car);

            Integer recordCount = car.getRecordCount();

            assertThat(recordCount).isEqualTo(expectedRecordCount);
        }
    }
}