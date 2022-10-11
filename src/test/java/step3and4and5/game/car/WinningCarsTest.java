package step3and4and5.game.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3and4and5.client.number.Number;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningCarsTest {

    @Test
    @DisplayName("우승자의 이름들을 반환 할 수 있다.")
    void a() {
        final Car winnerCar = new Car.Factory(new Number.Fake(1), new Position(1), "a").car();
        final Car loserCar = new Car.Factory(new Number.Fake(1), new Position(0), "b").car();

        final WinningCars sut = new WinningCars(new Cars(List.of(winnerCar, loserCar)));

        assertThat(sut.winners()).containsExactly("a");
    }
}
