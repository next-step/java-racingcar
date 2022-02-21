package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class WinnersTest {
    @Test
    void 자동차_리스트가_주어졌을때_맥스포지션이_5이면_포지션이_5인_자동차만_위너리스트에_포함된다() {
        Winners winners = new Winners(
            Arrays.asList(
                new Car("wonie", 3),
                new Car("pobie", 4),
                new Car("jonie", 5)
            )
        );
        assertThat(winners.winnerList()).hasSize(1);
    }

}