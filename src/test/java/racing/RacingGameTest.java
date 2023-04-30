package racing;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    @Test
    void startGame_NonMoveTest() {
        Cars cars = new Cars(List.of("a,b"));
        RacingGame racingGame = new RacingGame(cars);
        racingGame.startGame(new NonMove());
        cars.getCarDTOs()
            .forEach(carDTO -> assertThat(carDTO.getPosition()).isEqualTo(0));
    }

    @Test
    void startGame_MoveOneSpaceTest() {
        Cars cars = new Cars(List.of("a", "b"));
        List<CarDTO> expected = Arrays.asList(new CarDTO("a", 1), new CarDTO("b", 1));

        RacingGame racingGame = new RacingGame(cars);
        List<CarDTO> result = racingGame.startGame(new MoveOneSpace());

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void getTwoWinner_Test() {
        Cars cars = new Cars(List.of("a", "b"));

        RacingGame racingGame = new RacingGame(cars);
        racingGame.startGame(new MoveOneSpace());
        List<CarDTO> winners = racingGame.getWinner();

        assertThat(winners).containsExactly(
            new CarDTO("a", 1),
            new CarDTO("b", 1)
        );
    }

    @Test
    void getOneWinner_Test() {
        Cars cars = new Cars(List.of("a", "b"));
        CarDTO expected = new CarDTO("a", 1);

        RacingGame racingGame = new RacingGame(cars);
        racingGame.startGame(new MoveOddCase());
        List<CarDTO> winners = racingGame.getWinner();

        assertThat(winners).containsExactly(expected);
    }

}