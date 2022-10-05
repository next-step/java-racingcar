package carracing.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarTest {

    @DisplayName("4미만은 멈춘다")
    @ParameterizedTest
    @CsvSource(value = {"1,0", "2,0", "3,0"})
    public void tryMove_멈출수있다(int givenCondition, int expected) {
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

    @DisplayName("4이상은 이동한다")
    @ParameterizedTest
    @CsvSource(value = {"4,1", "5,1", "6,1", "7,1", "8,1", "9,1"})
    public void tryMove_이동할수있다(int givenCondition, int expected) {
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
