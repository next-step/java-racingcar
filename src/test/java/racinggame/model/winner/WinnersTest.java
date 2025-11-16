package racinggame.model.winner;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import racinggame.model.car.CarName;

class WinnersTest {

    @Test
    void 우승자_메세지를_콤마를_구분자로_출력할_수_있다() {
        List<CarName> winners = List.of(
                new CarName("first"),
                new CarName("second")
        );

        assertThat(
                new Winners(winners).getResultMessage()
        ).isEqualTo("first, second");
    }
}