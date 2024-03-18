package step5;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step5.domain.Racing;
import step5.domain.car.move.random.RandomCreator;
import step5.domain.car.move.random.RandomMoveStrategy;

class RacingTest {

    @DisplayName("참가하는 자동차와, 시도횟수를 입력받을 수 있다.")
    @Test
    void createRacing() {
        RandomCreator randomCreator = new RandomCreator();
        RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategy(randomCreator);

        Racing racing = Racing.createRacing(new String[]{"pobi", "temp", "test"}, 5, randomMoveStrategy);
        int carNumber = racing.getCarNumberOfParticipants();
        int tryNumber = racing.getTryNumber();
        Assertions.assertThat(carNumber).isEqualTo(3);
        Assertions.assertThat(tryNumber).isEqualTo(5);
    }
}
