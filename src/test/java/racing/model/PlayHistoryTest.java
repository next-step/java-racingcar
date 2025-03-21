package racing.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayHistoryTest {

    @Test
    @DisplayName("경기 기록에서 우승자 찾기")
    void 우승자_찾기() {
        List<CarsAtTurn> carsAtTurns = List.of(
                new CarsAtTurn(
                        List.of(
                                new FixedCar("a", 4),
                                new FixedCar("b", 4),
                                new FixedCar("c", 4)
                        )
                ),
                new CarsAtTurn(
                        List.of(
                                new FixedCar("a", 5),
                                new FixedCar("b", 4),
                                new FixedCar("c", 5)
                        )
                )
        );
        PlayHistory history = new PlayHistory(carsAtTurns);
        List<String> winners = history.findWinners();

        assertThat(winners).isEqualTo(List.of("a", "c"));
    }

}
