package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    private Cars cars;

    @BeforeEach
    public void setUp(){
        cars = new Cars(3);
    }

    @Test
    void playGame() {

        List<Car> cars = this.cars.playGame(new DiceWithRandom());

        assertThat(cars.size()).isEqualTo(3);
    }
}