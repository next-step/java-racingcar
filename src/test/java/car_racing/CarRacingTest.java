package car_racing;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarRacingTest {

    @Test
    @DisplayName("There are 4 possible cases when 1 car and 2 round")
    void play_withOneCar() {
        // given
        int numberOfCar = 1;
        int numberOfRound = 2;

        // when
        CarRacingGame carRacingGame = new CarRacingGame(numberOfCar, numberOfRound);
        String result = carRacingGame.play();

        // then
        assertThat(Lists.list(
                "\n\n\n\n",
                "\n\n-\n\n",
                "-\n\n-\n\n",
                "-\n\n--\n\n"
        ).contains(result)).isTrue();
    }

    @Test
    @DisplayName("There are 16 possible cases when 2 car and 2 round")
    void play_withTwoCar() {
        // given
        int numberOfCar = 2;
        int numberOfRound = 2;

        // when
        CarRacingGame carRacingGame = new CarRacingGame(numberOfCar, numberOfRound);
        String result = carRacingGame.play();

        // then
        assertThat(Lists.list(
                "\n\n\n\n\n\n",
                "\n\n\n-\n\n\n",
                "\n\n\n\n-\n\n",
                "\n\n\n-\n-\n\n",

                "-\n\n\n-\n\n\n",
                "-\n\n\n--\n\n\n",
                "-\n\n\n-\n-\n\n",
                "-\n\n\n--\n-\n\n",

                "\n-\n\n\n-\n\n",
                "\n-\n\n-\n-\n\n",
                "\n-\n\n\n--\n\n",
                "\n-\n\n-\n--\n\n",

                "-\n-\n\n-\n-\n\n",
                "-\n-\n\n--\n-\n\n",
                "-\n-\n\n-\n--\n\n",
                "-\n-\n\n--\n--\n\n"
        ).contains(result)).isTrue();
    }
}