package camp.nextstep.edu.racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RoundTest {

    @DisplayName("주어진 자동차의 개수에 대해서 round 객체를 잘 생성하는지")
    @Test
    void constructor() {
        final Round round = Round.initialRoundFrom(3);
        assertThat(round).isNotNull();
        assertThat(round.getCars().size()).isEqualTo(3);
    }

    @DisplayName("자동차들을 이동시키면, 그 결과로 이루어진 새 round 객체를 리턴해야함")
    @Test
    void move() {
        // given
        final Round round = Round.initialRoundFrom(3);
        round.getCars().stream().forEach(
                car -> assertThat(car.getPosition()).isEqualTo(0)
        );
        // when
        final MovingStrategy moveOnlyStrategy = new MoveOnlyStrategy();
        final Round movedRound = round.move(moveOnlyStrategy);
        // then
        assertThat(movedRound).isNotNull();
        movedRound.getCars().stream().forEach(
                car -> assertThat(car.getPosition()).isEqualTo(1)
        );
    }
}