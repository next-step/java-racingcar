package game.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    static class ZeroGenerator implements NumberGenerator{
        @Override
        public int getNumber() {
            return 0;
        }
    }

    static class FourGenerator implements NumberGenerator{
        @Override
        public int getNumber() {
            return 4;
        }
    }

    final List<Car> cars = new ArrayList<>();
    final NumberGenerator zeroGenerator = new ZeroGenerator();
    final NumberGenerator fourGenerator = new FourGenerator();

    @BeforeEach
    public void setUpCars(){
        for(int i =0; i < 5; i++){
            cars.add(new Car("test"));
        }
    }

    @Test
    @DisplayName("모든 자동차들이 전진한다")
    void all_cars_forward() {
        Game game = new Game(fourGenerator, cars);
        game.play();
        assertThat(game.getDistances()).containsExactly(2,2,2,2,2);
    }

    @Test
    @DisplayName("모든 자동차들이 제자리에 있는다")
    void all_cars_stay() {
        Game game = new Game(zeroGenerator, cars);
        game.play();
        assertThat(game.getDistances()).containsExactly(1,1,1,1,1);
    }
}