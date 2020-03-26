package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    private Cars cars;
    private RacingGame racingGame;

    @BeforeEach
    public void setup() {
        cars = new Cars(Arrays.asList(new Car("kks"),
                new Car("kjm"),
                new Car("bjs"),
                new Car("honux")));
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

        assertThat(cars).isEqualTo(new Cars(Arrays.asList(new Car("kks", 0),
                new Car("kjm", 0),
                new Car("bjs", 1),
                new Car("honux", 1))));
    }

    @Test
    public void getWinnerTest() {
        List<Integer> randomNumbers = new ArrayList<>();
        randomNumbers.add(0);
        randomNumbers.add(3);
        randomNumbers.add(4);
        randomNumbers.add(9);

        racingGame.playGame(randomNumbers);

        assertThat(racingGame.getWinners()).hasSize(2);
        assertThat(racingGame.getWinners()).contains("bjs", "honux");
    }


}
