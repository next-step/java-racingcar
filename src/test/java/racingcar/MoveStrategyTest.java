package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.service.MoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;

public class MoveStrategyTest {


    @Test
    void getIsMove() {
        //given
        MoveStrategy stubMoveStrategy = new StubMoveStrategy();

        //when
        Boolean result = stubMoveStrategy.getIsMove();

        //then
        assertThat(result).isFalse();
    }

    public class StubMoveStrategy implements MoveStrategy {
        @Override
        public Boolean getIsMove() {
            return false;
        }
    }

}
