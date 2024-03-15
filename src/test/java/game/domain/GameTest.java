package game.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    final List<Car> cars = new ArrayList<>();
    final FakeNumberGenerator generator = new FakeNumberGenerator();

    @BeforeEach
    public void setUpCars() {
        for (int i = 0; i < 5; i++) {
            cars.add(new Car("test" + i));
        }
    }

    @Test
    @DisplayName("모든 자동차들이 전진한다")
    void all_cars_forward() {
        generator.number = 4;
        Game game = new Game(generator, cars);
        game.play();
        assertThat(game.getDistances()).containsExactly(2, 2, 2, 2, 2);
    }

    @Test
    @DisplayName("모든 자동차들이 제자리에 있는다")
    void all_cars_stay() {
        generator.number = 3;
        Game game = new Game(generator, cars);
        game.play();
        assertThat(game.getDistances()).containsExactly(1, 1, 1, 1, 1);
    }

    static class FakeNumberGenerator implements NumberGenerator{
        public int number;
        @Override
        public int getNumber() {
            return number;
        }
    }
}