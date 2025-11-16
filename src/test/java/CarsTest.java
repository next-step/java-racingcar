import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    private final Car pobi = new Car("pobi", 5);
    private final Car crong = new Car("crong", 3);
    private final Car honux = new Car("honux", 5);

    @Test
    @DisplayName("Cars 에서 우승자를 계산해 반환한다.")
    void getWinnersTest() {
        Cars cars = new Cars(List.of(pobi, crong, honux));
        Winners winners = cars.winners();
        assertThat(winners).isEqualTo(new Winners(List.of(pobi, honux)));
    }
}
