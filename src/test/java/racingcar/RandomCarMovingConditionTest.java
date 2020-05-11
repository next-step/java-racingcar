package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RandomCarMovingConditionTest {

    @DisplayName("임계치보다 큰값이면 움직일수있다.")
    @ParameterizedTest()
    @CsvSource({
        "2,10,1,true",
        "2,10,2,true",
        "3,10,3,true",
        "5,10,4,true",
        "0,10,1,false",
        "0,10,2,false",
        "1,10,3,false",
        "2,10,4,false",
    })
    void moveIfNumberIsMoreThanThreshold(final int randomVal, int bound, int threshold, boolean canMove){
        RandomCarMovingCondition carMovingCondition = new RandomCarMovingCondition(
            b -> randomVal, bound, threshold);

        assertThat(carMovingCondition.canMove()).isEqualTo(canMove);
    }

}
