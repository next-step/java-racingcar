package racingcar;

import org.junit.jupiter.api.RepeatedTest;
import racingcar.model.RandomNumberStrategy;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberStrategyTest {

    @RepeatedTest(100)
    void randomNumberTest() {
        // given
        RandomNumberStrategy randomNumberStrategy = new RandomNumberStrategy();
        // when
        int moveNumber = randomNumberStrategy.getMoveNumber();
        //then
        assertThat(moveNumber).isGreaterThanOrEqualTo(0).isLessThan(10);

    }
}