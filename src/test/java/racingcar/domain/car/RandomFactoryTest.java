package racingcar.domain.car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.random.NoMoveGen;
import racingcar.domain.random.RandomFactory;
import racingcar.domain.random.MoveGen;

@DisplayName("자동차는 난수 값에 의해 정확하게 제어된다.")
class RandomFactoryTest {
    @DisplayName("랜덤 값 4 이상은 앞으로 전진한다")
    @Test
    void move() {
        //given
        final int BOUND = 4;
        RandomFactory randomFactory = RandomFactory.get();

        //when
        int random = randomFactory.getRandom(new MoveGen());

        //then
        assertThat(random >= BOUND).isTrue();
    }

    @DisplayName("랜덤 값 4 미만은 전지하지 않는다.")
    @Test
    void notMove() {
        //given
        final int BOUND = 4;
        RandomFactory randomFactory = RandomFactory.get();

        //when
        int random = randomFactory.getRandom(new NoMoveGen());

        //then
        assertThat(random >= BOUND).isFalse();
    }
}