package racing_game;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Objects;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    private RacingGame racingGame;

    @Before
    public void setup() {
        this.racingGame = new RacingGame();
    }

    @Test
    public void 자동차_수_입력받기() {
        final int inputCarCount = 5;

        InputStream input = new ByteArrayInputStream(String.valueOf(inputCarCount).getBytes());
        try (Scanner scanner = new Scanner(input)) {
            int carCount = racingGame.readCarCount(scanner);
            assertThat(carCount).isEqualTo(inputCarCount);
        }
    }

    @Test
    public void 배열만들기() {
        final int carCount = 2;

        StringBuilder[] cars = racingGame.createCars(carCount);

        assertThat(cars.length).isEqualTo(carCount);
        assertThat(cars).allMatch(Objects::nonNull);
    }

    @Test
    public void 시도_횟수_입력빋가() {
        final int inputTryCount = 3;

        InputStream input = new ByteArrayInputStream(String.valueOf(inputTryCount).getBytes());
        try (Scanner scanner = new Scanner(input)) {
            int tryCount = racingGame.readTryCount(scanner);
            assertThat(tryCount).isEqualTo(inputTryCount);
        }
    }

    @Test
    public void 전진여부확인() {
        boolean yes = racingGame.isMove(4);
        boolean no = racingGame.isMove(3);

        assertThat(yes).isTrue();
        assertThat(no).isFalse();
    }

    @Test
    public void 이동하기() {
        final StringBuilder car = new StringBuilder("-");
        racingGame.move(car, 3);

        assertThat(car.toString()).isEqualTo("-");

        racingGame.move(car, 4);

        assertThat(car.toString()).isEqualTo("--");
    }

}