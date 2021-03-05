package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.MovingStrategy;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCarList;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    private MovingStrategy createFixedMovingStrategy(boolean movable) {
        return new MovingStrategy() {
            @Override
            public boolean isMovable() {
                return movable;
            }
        };
    }
    @ParameterizedTest
    @CsvSource(value = {"true:1","true:1","false:0"}, delimiter = ':')
    @DisplayName("자동차 move 테스트")
    void move(boolean movable, int expectedTravelDistance) {
        RacingCar test = new RacingCar(createFixedMovingStrategy(movable));
        test.move();
        assertThat(test.getTravelledDistance()).isEqualTo(expectedTravelDistance);
    }

    @ParameterizedTest
    @CsvSource(value = {"true:4:1","false:5:0"}, delimiter = ':')
    @DisplayName("자동차 리스트 move 테스트")
    void moveList(boolean movable, int carNumber, int expectedTravelDistance) {
        RacingCarList racingCarList = new RacingCarList(carNumber, createFixedMovingStrategy(movable));
        racingCarList.move();
        racingCarList.getIndividualScore()
                .forEach(carScore ->
                assertThat(carScore.getTravelledDistance()).isEqualTo(expectedTravelDistance)
        );
    }
}
