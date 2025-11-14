import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {

    @Test
    @DisplayName("Winners 객체가 우승자를 정확히 반환한다.")
    void getWinnersTest() {
        final Car pobi = new Car("pobi", 5);
        final Car crong = new Car("crong", 3);
        final Car honux = new Car("honux", 5);
        Winners winners = new Winners(List.of(pobi, crong, honux));
        assertThat(winners.winners()).hasSize(2);
        assertThat(winners.winners()).containsExactly(pobi, honux);
    }
}