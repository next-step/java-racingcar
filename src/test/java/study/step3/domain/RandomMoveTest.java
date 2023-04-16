package study.step3.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomMoveTest {

    private RandomMove randomMove;

    @BeforeEach
    void init() {
        randomMove = new RandomMove();
    }

    @Test
    void createMove_범위확인() {
        //given

        //when
        int number = randomMove.createMove();

        //then
        assertThat(number).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(10);
    }
}