package racing.domain.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racing.domain.dto.CarDTO;
import racing.domain.move.MoveOddCase;
import racing.domain.move.MoveOneSpace;
import racing.domain.move.NonMove;

class RacingGameTest {

    @Test
    void startGame_NonMoveTest() {
        Cars cars = new Cars(List.of("a,b"));
        RacingGame racingGame = new RacingGame(cars, 2);
        racingGame.startGame(new NonMove());
        cars.getCarDTOs()
            .forEach(carDTO -> assertThat(carDTO.getPosition()).isEqualTo(0));
    }

    @Test
    void isOverTest() {
        RacingGame racingGame = new RacingGame(new Cars(List.of("a")), 2, 2);
        assertThat(racingGame.isOver()).isTrue();
    }

    @Test
    void isNotOverTest() {
        RacingGame racingGame = new RacingGame(new Cars(List.of("a")), 2, 1);
        assertThat(racingGame.isOver()).isFalse();
    }

    @Test
    void startGame_MoveOneSpaceTest() {
        Cars cars = new Cars(List.of("a", "b"));
        List<CarDTO> expected = Arrays.asList(new CarDTO("a", 1), new CarDTO("b", 1));

        RacingGame racingGame = new RacingGame(cars, 2);
        List<CarDTO> result = racingGame.startGame(new MoveOneSpace());

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void getTwoWinner_Test() {
        Cars cars = new Cars(List.of("a", "b"));

        RacingGame racingGame = new RacingGame(cars, 2);
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

        RacingGame racingGame = new RacingGame(cars, 2);
        racingGame.startGame(new MoveOddCase());
        List<CarDTO> winners = racingGame.getWinner();

        assertThat(winners).containsExactly(expected);
    }

}