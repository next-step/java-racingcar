package racingcarGame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcarGame.model.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcarGame.RacingGame.findWinner;

class RacingGameTest {

    @Test
    @DisplayName("게임 우승자가 1명의 경우 검증")
    public void find_winner() {
        List<Car> cars = List.of(
                new Car(4, "bella"),
                new Car(3, "demian")
        );

        String result = findWinner(cars);

        assertThat(result).isEqualTo("bella");
    }

    @Test
    @DisplayName("게임 우승자가 여러 명의 경우 검증")
    public void find_winners() {
        List<Car> cars = List.of(
                new Car(4, "bella"),
                new Car(4, "demian"),
                new Car(2, "tina")
        );

        String result = findWinner(cars);

        assertThat(result).isEqualTo("bella, demian");
    }
}