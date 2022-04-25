package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {

    @DisplayName("경기용 차가 N대 준비된다.")
    @Test
    void numberOfCars() {
        final Game game = new Game(NumberOfRound.of(5), getDefaultRule());
        final List<Car> cars = game.equipRacingCar(NumberOfCars.of(3));

        assertThat(cars).hasSize(3);
    }

    @DisplayName("경기를 N번 진행한다.")
    @Test
    void proceedRound() {
        final Game game = new Game(NumberOfRound.of(5), getDefaultRule());
        game.equipRacingCar(NumberOfCars.of(3));

        int count = 0;
        while (game.isLeftRound()) {
            game.proceedRound();
            count++;
        }

        assertThat(count).isEqualTo(5);
    }

    GameRule getDefaultRule() {
        return () -> true;
    }
}
