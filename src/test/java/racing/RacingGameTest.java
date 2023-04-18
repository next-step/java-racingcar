package racing;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    @Test
    void startGame_NonMoveTest() {
        Cars cars = new Cars("a,b");
        RacingGame racingGame = new RacingGame(2, cars);
        racingGame.startGame(new NonMove());
        cars.getCarDTOs()
            .forEach(carDTO -> assertThat(carDTO.getPosition()).isEqualTo(0));
    }

    @Test
    void startGame_MoveOneSpaceTest() {
        Cars cars = new Cars("a,b");
        List<List<CarDTO>> expected = Arrays.asList(
            Arrays.asList(new CarDTO("a", 1), new CarDTO("b", 1)),
            Arrays.asList(new CarDTO("a", 2), new CarDTO("b", 2)));

        RacingGame racingGame = new RacingGame(2, cars);
        List<List<CarDTO>> result = racingGame.startGame(new MoveOneSpace());

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void getWinner_Test() {
        Cars cars = new Cars("a,b");
        RacingGame racingGame = new RacingGame(2, cars);
        racingGame.startGame(new MoveOneSpace());
        List<CarDTO> winners = racingGame.getWinner();
        assertThat(winners).hasSize(2);
    }

}