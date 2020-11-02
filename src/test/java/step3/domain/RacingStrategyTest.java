package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;
import step3.util.RandomGenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockStatic;

@DisplayName("레이싱 전략 테스트")
public class RacingStrategyTest {
    @DisplayName("4이상일 경우에 자동차를 움직임")
    @ParameterizedTest(name = "랜덤값: {0} -> 자동차 position: {1}")
    @CsvSource(value = {"0.0:0", "0.1:0", "0.2:0", "0.3:0", "0.4:1", "0.5:1", "0.6:1", "0.7:1", "0.8:1", "0.9:1"}, delimiter = ':')
    public void moveWithRandom(double randomValue, Integer expectedPosition) {
        try (MockedStatic<RandomGenerator> mocked = mockStatic(RandomGenerator.class)) {
            mocked.when(RandomGenerator::getRandomBetweenZeroToOne).thenReturn(randomValue);
            Car car = new Car(0);
            RacingStrategy.move(car);
            Integer position = car.getPosition();
            assertThat(position).isEqualTo(expectedPosition);
        }
    }

}