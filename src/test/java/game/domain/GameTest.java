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

    @Test
    @DisplayName("우승자 한 명")
    void single_winner() {
        FakeNumbersGenerator numbersGenerator = new FakeNumbersGenerator();
        numbersGenerator.numbers = new int[] {1,1,4,1,1};
        Game game = new Game(numbersGenerator, cars);
        game.play();
        List<Car> winners = game.getWinner();
        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners.get(0).getName()).isEqualTo("test2");
    }

    @Test
    @DisplayName("우승자가 여러 명이 나온다")
    void multiple_winner() {
        FakeNumbersGenerator numbersGenerator = new FakeNumbersGenerator();
        numbersGenerator.numbers = new int[] {1,4,4,1,1};
        Game game = new Game(numbersGenerator, cars);
        game.play();
        List<Car> winners = game.getWinner();
        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners.get(0).getName()).contains("test1");
        assertThat(winners.get(1).getName()).contains("test2");
    }

    static class FakeNumberGenerator implements NumberGenerator{
        public int number;
        @Override
        public int getNumber() {
            return number;
        }
    }

    static class FakeNumbersGenerator implements NumberGenerator{
        public int[] numbers;
        private int index=0;
        @Override
        public int getNumber() {
            return numbers[index++];
        }
    }
}