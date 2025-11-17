package racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {
    @Test
    @DisplayName("우승자 이름들을 정확히 반환한다.")
    void getNamesTest() {
        final Car pobi = new Car("pobi", 5);
        final Car honux = new Car("honux", 5);
        Winners winners = new Winners(List.of(pobi, honux));
        assertThat(winners.getNames()).isEqualTo(List.of(new CarName("pobi"), new CarName("honux")));
    }
}