package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class WinnersTest {
    @Test
    void 자동차_리스트가_주어졌을때_가장_멀리_이동한_자동차만_위너리스트에_포함된다1() {
        Winners winners = new Winners(
            Arrays.asList(
                new Car("wonie", 3),
                new Car("pobie", 4),
                new Car("jonie", 5)
            )
        );
        assertThat(winners.getRaceResults()).hasSize(1);
    }

    @Test
    void 자동차_리스트가_주어졌을때_가장_멀리_이동한_자동차만_위너리스트에_포함된다2() {
        Winners winners = new Winners(
            Arrays.asList(
                new Car("wonie", 3),
                new Car("pobie", 5),
                new Car("jonie", 5)
            )
        );
        assertThat(winners.getRaceResults()).hasSize(2);
    }


}