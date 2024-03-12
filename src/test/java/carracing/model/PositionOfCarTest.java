package carracing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PositionOfCarTest {
    @ParameterizedTest
    @CsvSource(value = {"0:10:0", "1:1:1", "1:2:2", "3:1:3", "2:5:10"}, delimiter = ':')
    @DisplayName("increase(): increaseAmount 만큼 position을 증가시키고 증가된 결과를 postionHistory에 추가한다.")
    void testPositionIncrease(int numberOfIncrease, int increaseAmount, int expectedPosition) {
        PositionOfCar positionOfCar = PositionOfCar.startPositionOfCar();

        for (int i = 0; i < numberOfIncrease; i++) {
            positionOfCar.increase(increaseAmount);
        }

        assertThat(positionOfCar.position()).isEqualTo(expectedPosition);
        assertThat(positionOfCar.positionHistory().size()).isEqualTo(numberOfIncrease);
    }
}