package car_racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarTest {

    @ParameterizedTest
    @CsvSource(value = {"1,0", "9,1"})
    public void tryMove_직진한다(int givenCondition, int expected) {
        Car car = new Car();

        car.tryMove(new MovableStrategy<Integer>() {
            @Override
            public Integer getCondition() {
                return givenCondition;
            }

            @Override
            public boolean predicate(Integer condition) {
                return GameRule.isGoStraight(condition);
            }
        });

        Assertions.assertThat(car.getMoveResult().getStraightCount()).isEqualTo(expected);
    }

}
