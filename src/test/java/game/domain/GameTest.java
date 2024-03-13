package game.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    final List<Car> cars = new ArrayList<>();
    final NumberGenerator zeroGenerator = new ZeroGenerator();
    final NumberGenerator fourGenerator = new FourGenerator();

    @BeforeEach
    public void setUpCars() {
        for (int i = 0; i < 5; i++) {
            cars.add(new Car("test" + i));
        }
    }

    @Test
    @DisplayName("모든 자동차들이 전진한다")
    void all_cars_forward() {
        Game game = new Game(fourGenerator, cars);
        game.play();
        assertThat(game.getDistances()).containsExactly(2, 2, 2, 2, 2);
    }

    @Test
    @DisplayName("모든 자동차들이 제자리에 있는다")
    void all_cars_stay() {
        Game game = new Game(zeroGenerator, cars);
        game.play();
        assertThat(game.getDistances()).containsExactly(1, 1, 1, 1, 1);
    }

    @Test
    @DisplayName("우승자 한 명")
    void single_winner() {
        NumberGenerator generator = new SingleWinnerGenerator();
        Game game = new Game(generator, cars);
        game.play();
        List<Car> winners = game.getWinner();
        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners.get(0).getName()).isEqualTo("test2");
    }

    @Test
    @DisplayName("우승자가 여러 명이 나온다")
    void multiple_winner() {
        NumberGenerator generator = new MultipleWinnerGenerator();
        Game game = new Game(generator, cars);
        game.play();
        List<Car> winners = game.getWinner();
        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners.get(0).getName()).contains("test1");
        assertThat(winners.get(1).getName()).contains("test2");
    }

    static class ZeroGenerator implements NumberGenerator {
        @Override
        public int getNumber() {
            return 0;
        }
    }

    static class FourGenerator implements NumberGenerator {
        @Override
        public int getNumber() {
            return 4;
        }
    }

    static class SingleWinnerGenerator implements NumberGenerator {
        private int count = 0;

        @Override
        public int getNumber() {
            if (count++ % 5 == 2) {
                return 4;
            }
            return 0;
        }
    }

    static class MultipleWinnerGenerator implements NumberGenerator {
        private int count = 0;

        @Override
        public int getNumber() {
            count++;
            if (count % 5 == 2 || count % 5 == 3) {
                return 4;
            }
            return 0;
        }
    }
}