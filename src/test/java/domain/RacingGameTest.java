package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    private RacingGame racingGame;
    private List<Car> cars;

    @BeforeEach
    public void setup() {
        cars = new ArrayList<>();
        cars.add(new Car("kks"));
        cars.add(new Car("kjm"));
        cars.add(new Car("bjs"));
        cars.add(new Car("honux"));
        racingGame = new RacingGame(cars);
    }

    @DisplayName("4이상의 숫자를 받은 차만 1칸 전진")
    @Test
    public void playGameTest() {
        List<Integer> randomNumbers = new ArrayList<>();
        randomNumbers.add(0);
        randomNumbers.add(3);
        randomNumbers.add(4);
        randomNumbers.add(9);

        racingGame.playGame(randomNumbers);

        assertThat(cars.get(0)).isEqualTo(new Car("kks", 1));
        assertThat(cars.get(1)).isEqualTo(new Car("kjm", 1));
        assertThat(cars.get(2)).isEqualTo(new Car("bjs", 2));
        assertThat(cars.get(3)).isEqualTo(new Car("honux", 2));
    }


}
